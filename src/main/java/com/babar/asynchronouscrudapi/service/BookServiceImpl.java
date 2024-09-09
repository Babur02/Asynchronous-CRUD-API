package com.babar.asynchronouscrudapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.babar.asynchronouscrudapi.entity.Book;
import com.babar.asynchronouscrudapi.repository.BookRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Mono<Book> create(Book book) {
        Mono<Book> createdBook = bookRepository.save(book);
        return createdBook;
    }

    @Override
    public Flux<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public Mono<Book> get(int bookId) {
        Mono<Book> book = bookRepository.findById(bookId);
        return book;
    }

    @Override
    public Mono<Book> update(Book book, int bookId) {
        Mono<Book> oldBook = bookRepository.findById(bookId);
        return oldBook.flatMap(book1 -> {
            book1.setName(book.getName());
            book1.setDescription(book.getDescription());
            book1.setAuthor(book.getAuthor());
            book1.setPublisher(book.getPublisher());
            return bookRepository.save(book1);
        });

    }

    @Override
    public Mono<Void> delete(int bookId) {
        return bookRepository.findById(bookId).flatMap(book -> bookRepository.delete(book));
    }

    @Override
    public Flux<Book> search(String query) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'search'");
    }

}

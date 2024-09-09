package com.babar.asynchronouscrudapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.babar.asynchronouscrudapi.entity.Book;
import com.babar.asynchronouscrudapi.service.BookService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;




@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public Mono<Book> create(@RequestBody Book book){
        return bookService.create(book);
    }

    @GetMapping
    public Flux<Book> getAll() {
        return bookService.getAll();
    }

    @GetMapping("{bookId}")
    public Mono<Book> getBook(@PathVariable int bookId) {
        return bookService.get(bookId);
    }
    
    @PutMapping("{bookId}")
    public Mono<Book> update(@RequestBody Book book,@PathVariable int bookId) {
     return bookService.update(book, bookId);
    }

    @DeleteMapping("{bookId}")
    public Mono<Void> delete(@PathVariable int bookId){
        return bookService.delete(bookId);
    }
    

}

package com.babar.asynchronouscrudapi.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.babar.asynchronouscrudapi.entity.Book;

@Repository
public interface BookRepository extends ReactiveCrudRepository<Book,Integer> {

}

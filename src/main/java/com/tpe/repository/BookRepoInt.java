package com.tpe.repository;

import com.tpe.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepoInt {
    void save(Book book);
    List<Book> getAllBooks();
    Optional<Book> findById(Long id);//NullPointerException almamak için
    void delete(Book book);

}

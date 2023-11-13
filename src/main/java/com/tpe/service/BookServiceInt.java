package com.tpe.service;

import com.tpe.entity.Book;

import java.util.List;

public interface BookServiceInt {
   void saveBook(Book book);
   List<Book> getAllBooks();
   Book FindByBookId(Long id);
   void delete(Long id);

}

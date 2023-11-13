package com.tpe.service;

import com.tpe.entity.Book;
import com.tpe.exceptions.ResourceNotFoundException;
import com.tpe.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService implements BookServiceInt{
    @Autowired
    private BookRepo bookRepo;
    @Override
    public void saveBook(Book book) {
        bookRepo.save(book);
    }

    @Override
    public List<Book> getAllBooks() {
        List<Book> bookList=  bookRepo.getAllBooks();
        return bookList;
    }

    @Override
    public Book FindByBookId(Long id) {

        Book book=bookRepo.findById(id).
                orElseThrow(()-> new ResourceNotFoundException("Book is not found"+id));
        return book;
    }

    @Override
    public void delete(Long id) {

        Book book=FindByBookId(id);
        bookRepo.delete(book);
    }
}

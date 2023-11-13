package com.tpe.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.awt.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "t_books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message="Please write book name")
    private String bookName;
    @NotBlank(message="Please write Auther name")
    private String bookAuther;
    @NotBlank(message="Please write publisher name")
    private String publisher;
    private LocalDateTime createDate=LocalDateTime.now();

    public Long getId() {
        return id;
    }
   public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuther() {
        return bookAuther;
    }

    public void setBookAuther(String bookAuther) {
        this.bookAuther = bookAuther;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }
}

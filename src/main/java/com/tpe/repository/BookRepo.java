package com.tpe.repository;

import com.tpe.entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class BookRepo implements BookRepoInt{
    private SessionFactory sessionFactory;
    @Override
    public void save(Book book) {
     Session session=  sessionFactory.openSession();
     Transaction tx= session.beginTransaction();

     session.saveOrUpdate(book);

     tx.commit();
     session.close();
    }

    @Override
    public List<Book> getAllBooks() {
        Session session=  sessionFactory.openSession();
        Transaction tx= session.beginTransaction();

        List<Book> bookList=  session.createQuery("FROM t_books",Book.class).getResultList();

        tx.commit();
        session.close();
        return bookList;
    }

    @Override
    public Optional<Book> findById(Long id) {

        Session session=  sessionFactory.openSession();
        Transaction tx= session.beginTransaction();

        Book book= session.get(Book.class,id);
        Optional<Book> optional= Optional.ofNullable(book);

        tx.commit();
        session.close();
        return optional;
    }

    @Override
    public void delete(Book book) {
        Session session=  sessionFactory.openSession();
        Transaction tx= session.beginTransaction();

        session.delete(book);

        Optional<Book> optional= Optional.ofNullable(book);

        tx.commit();
        session.close();
    }
}

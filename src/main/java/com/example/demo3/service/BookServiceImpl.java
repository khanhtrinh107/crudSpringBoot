package com.example.demo3.service;

import com.example.demo3.entity.Book;
import com.example.demo3.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    private BookRepository bookRepository;
    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book getById(int id) {
        return bookRepository.findById(id).orElseThrow();
    }

    @Override
    public void  deleteById(int id) {
        bookRepository.deleteById(id);
    }


    @Override
    public Book create(Book book) {

        return bookRepository.save(book);
    }

    @Override
    public Book update(Book book, int id) {
        Book book1 = bookRepository.findById(id).orElseThrow();
        book1.setApproved(book.isApproved());
        book1.setCategory(book.getCategory());
        book1.setAuthor(book.getAuthor());
        book1.setTitle(book.getTitle());
        return bookRepository.save(book1);
    }

    @Override
    public boolean check(String title, String author) {
        if(bookRepository.Check(title,author) != null){
            return true;
        }
        return false;
    }
}

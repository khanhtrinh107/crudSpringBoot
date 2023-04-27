package com.example.demo3.service;

import com.example.demo3.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> getAll();
    Book getById(int id);
    void deleteById(int id);
    Book create(Book book);
    Book update(Book book , int id);
    boolean check(String title, String author);
}

package com.example.demo3.repository;

import com.example.demo3.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookRepository extends JpaRepository<Book , Integer> {
    @Query("select b from Book b where b.title = ?1 and b.author = ?2")
    Book Check(String title , String author);
}

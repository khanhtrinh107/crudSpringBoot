package com.example.demo3.controller;

import com.example.demo3.entity.Book;
import com.example.demo3.service.BookService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@CrossOrigin(origins = "*")
public class BookController {
    @Autowired
    private BookService bookService;
    @GetMapping("/books2")
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(bookService.getAll() , HttpStatus.OK);
    }
    @GetMapping("/book/{bookcode}")
    public ResponseEntity<?> findByBookCode(@PathVariable int bookcode){
        return new ResponseEntity<>(bookService.getById(bookcode) , HttpStatus.OK);
    }
    @PostMapping("/book/save/{bookcode}")
    public ResponseEntity<?> create(@RequestBody Book book , @PathVariable int bookcode){
        if(bookService.check(book.getTitle() , book.getAuthor())){
            return new ResponseEntity<>(new Error("Book existed!") , HttpStatus.OK);
        }
        return new ResponseEntity<>(bookService.create(book) , HttpStatus.CREATED);
    }
    @PutMapping("/book/save/{bookcode}")
    public ResponseEntity<?> update(@RequestBody Book book , @PathVariable int bookcode){
        if(bookService.check(book.getTitle() , book.getAuthor())){
            return new ResponseEntity<>(new Error("Book existed!") , HttpStatus.OK);
        }
        System.out.println("OK");
        return new ResponseEntity<>(bookService.update(book,bookcode) , HttpStatus.OK);
    }
    @DeleteMapping("/book/delete/{bookcode}")
    public ResponseEntity<?> delete(@PathVariable int bookcode){
        bookService.deleteById(bookcode);
        HashMap<String,String> res = new HashMap<>();
        res.put("message" , "OK");
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}

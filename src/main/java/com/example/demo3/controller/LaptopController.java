package com.example.demo3.controller;

import com.example.demo3.entity.Laptop;
import com.example.demo3.service.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@CrossOrigin
public class LaptopController {
    @Autowired
    private LaptopService laptopService;

    @GetMapping("/laptops")
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(laptopService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/laptop/{id}")
    public ResponseEntity<?> findByBookCode(@PathVariable int id) {
        return new ResponseEntity<>(laptopService.getById(id), HttpStatus.OK);
    }

    @PostMapping("/laptop/save/{id}")
    public ResponseEntity<?> create(@RequestBody Laptop laptop, @PathVariable int id) {
        if (laptopService.check(laptop.getName(), laptop.getBrand())) {
            return new ResponseEntity<>(new Error("Book existed!"), HttpStatus.OK);
        }
        return new ResponseEntity<>(laptopService.create(laptop), HttpStatus.CREATED);
    }

    @PutMapping("/laptop/save/{id}")
    public ResponseEntity<?> update(@RequestBody Laptop laptop, @PathVariable int bookcode) {
        if (laptopService.check(laptop.getName(), laptop.getBrand())) {
            return new ResponseEntity<>(new Error("Book existed!"), HttpStatus.OK);
        }
        System.out.println("OK");
        return new ResponseEntity<>(laptopService.update(laptop, bookcode), HttpStatus.OK);
    }

    @DeleteMapping("/laptop/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        laptopService.deleteById(id);
        HashMap<String, String> res = new HashMap<>();
        res.put("message", "OK");
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}

package com.example.demo3.service;

import com.example.demo3.entity.Laptop;

import java.util.List;

public interface LaptopService {
    List<Laptop> getAll();
    Laptop getById(int id);
    void deleteById(int id);
    Laptop create(Laptop laptop);
    Laptop update(Laptop laptop , int id);
    boolean check(String name, String brand);
}

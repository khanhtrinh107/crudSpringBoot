package com.example.demo3.service;

import com.example.demo3.entity.Laptop;
import com.example.demo3.repository.LaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaptopServiceImpl implements LaptopService {
    @Autowired
    private LaptopRepository laptopRepository;
    @Override
    public List<Laptop> getAll() {
        return laptopRepository.findAll();
    }

    @Override
    public Laptop getById(int id) {
        return laptopRepository.findById(id).orElseThrow();
    }

    @Override
    public void  deleteById(int id) {
        laptopRepository.deleteById(id);
    }


    @Override
    public Laptop create(Laptop book) {

        return laptopRepository.save(book);
    }

    @Override
    public Laptop update(Laptop book, int id) {
        Laptop laptop = laptopRepository.findById(id).orElseThrow();
        laptop.setSold(book.isSold());
        laptop.setName(book.getName());
        laptop.setNgaySx(book.getNgaySx());
        laptop.setBrand(book.getBrand());
        return laptopRepository.save(laptop);
    }

    @Override
    public boolean check(String title, String author) {
        if(laptopRepository.Check(title,author) != null){
            return true;
        }
        return false;
    }
}

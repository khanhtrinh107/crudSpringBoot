package com.example.demo3.repository;

import com.example.demo3.entity.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LaptopRepository extends JpaRepository<Laptop, Integer> {
    @Query("select b from Laptop b where b.name = ?1 and b.brand = ?2")
    Laptop Check(String name , String brand);
}

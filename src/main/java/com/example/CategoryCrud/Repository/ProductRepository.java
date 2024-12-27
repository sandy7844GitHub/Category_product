package com.example.CategoryCrud.Repository;

import com.example.CategoryCrud.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ProductRepository extends JpaRepository<Product, Long> {

}

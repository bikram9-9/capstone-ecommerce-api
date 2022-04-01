package com.capstone.ecommerce.dao;

import com.capstone.ecommerce.model.Category;
import com.capstone.ecommerce.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProductRepository extends CrudRepository<Product, Long> {

    Optional<Product> findById(Long Id);
//    Category findByFirstName(String id);
}

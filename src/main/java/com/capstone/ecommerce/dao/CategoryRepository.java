package com.capstone.ecommerce.dao;

import com.capstone.ecommerce.model.Category;
import com.capstone.ecommerce.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    Optional<Category> findById(Long Id);
//    Category findByName(String categoryName);
}

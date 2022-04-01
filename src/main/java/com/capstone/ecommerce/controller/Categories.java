package com.capstone.ecommerce.controller;

import com.capstone.ecommerce.dao.CategoryRepository;
import com.capstone.ecommerce.dao.ProductRepository;
import com.capstone.ecommerce.model.Category;
import com.capstone.ecommerce.model.Product;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.rmi.ServerException;
import java.rmi.server.ServerCloneException;
import java.util.List;


@RestController
@RequestMapping("/category")
public class Categories {

    private Category category;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("all")
    private ResponseEntity<List<Category>> getAllCategories(){
        return new ResponseEntity(categoryRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<Category> createCategory(@RequestBody Category category) throws ServerException {
        Category newCategory = categoryRepository.save(category);

        if(newCategory == null ){
            throw new ServerException("NEED USER CONTENT");
        }else{
            return new ResponseEntity<>(newCategory, HttpStatus.CREATED);
        }
    }

}

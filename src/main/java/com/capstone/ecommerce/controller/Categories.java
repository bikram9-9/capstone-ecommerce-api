package com.capstone.ecommerce.controller;

import com.capstone.ecommerce.dao.CategoryRepository;
import com.capstone.ecommerce.dao.ProductRepository;
import com.capstone.ecommerce.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.rmi.ServerException;
import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins ="*", allowedHeaders = "*")
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
        System.out.println("THIS IS THE ID "+ newCategory.getId());
        System.out.println("THIS IS THE ID "+ newCategory.getName());

        if(newCategory == null ){
            throw new ServerException("NEED USER CONTENT");
        }else{
            return new ResponseEntity<>(newCategory, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Category> removeCategoryById(@PathVariable("id") Long categoryId) throws NoSuchFieldException {
        if(categoryRepository.findById(categoryId).isPresent()){
          categoryRepository.deleteById(categoryId);
          return new ResponseEntity(HttpStatus.ACCEPTED);
        }else{
            throw new NoSuchFieldException("NO CATEGORY FOUND");
        }
    }

}

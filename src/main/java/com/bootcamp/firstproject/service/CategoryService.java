package com.bootcamp.firstproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bootcamp.firstproject.model.Category;

@Service
public interface CategoryService {
    
    List<Category> findAllCategory();

    Category addCategory(Category category);

    Optional<Category> findCategoryById(Long cateId);

    void deleteCategoryById(Long cateId);
}

package com.bootcamp.firstproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.firstproject.model.Category;
import com.bootcamp.firstproject.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository cateRepo;

    @Override
    public List<Category> findAllCategory() {
        return cateRepo.findAll();
    }

    @Override
    public Category addCategory(Category category) {
        return cateRepo.save(category);
    }

    @Override
    public Optional<Category> findCategoryById(Long cateId) {
        return cateRepo.findById(cateId);
    }

    @Override
    public void deleteCategoryById(Long cateId) {
        cateRepo.deleteById(cateId);
        
    }
    
}

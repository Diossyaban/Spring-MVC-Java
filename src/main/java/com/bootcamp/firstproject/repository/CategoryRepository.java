package com.bootcamp.firstproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootcamp.firstproject.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
    
}

package com.bootcamp.firstproject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bootcamp.firstproject.model.Category;
import com.bootcamp.firstproject.repository.CategoryRepository;
import com.bootcamp.firstproject.service.CategoryService;

@Tag("fast")
public class CategoryServiceTest {
    
    @Autowired
    private CategoryRepository cateRepo;

    @Autowired
    private CategoryService cateService;

    public void createCategoryTest(){
        Category category = new Category();
        category.setCateName("CREWNECK");
        cateService.addCategory(category);
        Assertions.assertEquals(1, cateRepo.count());
    }

    @Test
    public void test(){
        Assertions.assertEquals(2, 1 + 1);
    }
}

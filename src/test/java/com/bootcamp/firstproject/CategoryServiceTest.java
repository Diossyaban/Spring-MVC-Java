package com.bootcamp.firstproject;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bootcamp.firstproject.model.Category;
import com.bootcamp.firstproject.repository.CategoryRepository;
import com.bootcamp.firstproject.service.CategoryService;

@SpringBootTest
public class CategoryServiceTest {
    
    @Autowired
    private CategoryRepository cateRepo;

    @Autowired
    private CategoryService cateService;

    @Test
    public void createCategoryTest(){
        Category category = new Category(null, "JACKET");
        cateService.addCategory(category);
        Assertions.assertEquals(1, cateRepo.count());
    }

    @Test
    public void test(){
        Assertions.assertEquals(2, 1 + 1);
    }
}

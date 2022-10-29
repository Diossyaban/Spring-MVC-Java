package com.bootcamp.firstproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bootcamp.firstproject.service.CategoryService;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService cateService;

    @GetMapping("/")
    public String showCategory(Model model){
        model.addAttribute("categories", cateService.findAllCategory());
        return "modul/category/category.html";
    }
}

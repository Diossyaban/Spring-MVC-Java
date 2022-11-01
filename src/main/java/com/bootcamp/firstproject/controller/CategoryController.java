package com.bootcamp.firstproject.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bootcamp.firstproject.model.Category;
import com.bootcamp.firstproject.service.CategoryService;

@Controller
@RequestMapping("/category")
public class CategoryController {

    private static Logger logger = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    private CategoryService cateService;

    @GetMapping("/")
    public String showCategory(Model model){
        model.addAttribute("isHome", false);
        model.addAttribute("categories", cateService.findAllCategory());
        return "modul/category/category.html";
    }

    @GetMapping("add")
    public String addCategory(Model model){
        model.addAttribute("category", new Category());
        model.addAttribute("action", "Add Category");
        return "modul/category/addEdit.html";
    }

    @PostMapping("add")
    public String postCategory(@Valid Category category, BindingResult result, RedirectAttributes redirectAttrs){
        if(result.hasErrors()){
            return "modul/category/addEdit.html";
        }
        cateService.addCategory(category);
        redirectAttrs.addFlashAttribute("message", "Category " + category.getCateName() + " created.");
        return "redirect:/category/";
    }

    @GetMapping("edit/{id}")
    public String editCategoryById(@PathVariable("id") Long cateId, Model model){
        Optional<Category> category = cateService.findCategoryById(cateId);
        model.addAttribute("action", "Edit Category");
        model.addAttribute("category", category.get());
        return "modul/category/addEdit.html";
    }

    @GetMapping("delete/{id}")
    public String deleteCategoryById(@PathVariable("id") Long cateId, RedirectAttributes redirectAttrs){
        cateService.deleteCategoryById(cateId);
        redirectAttrs.addFlashAttribute("message", "Category " + cateId +" deleted.");
        return "redirect:/category/";
    }

    // untuk menghandle error
    @ExceptionHandler(Exception.class)
    public ModelAndView handleError(HttpServletRequest req, Exception ex){
        logger.error("Category Not Found");
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", ex.getMessage());
        mav.addObject("url", req.getRequestURL());
        mav.setViewName("404");
        return mav;
    }
}

package com.bootcamp.firstproject.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bootcamp.firstproject.model.Product;
import com.bootcamp.firstproject.service.CategoryService;
import com.bootcamp.firstproject.service.ProductService;
import com.bootcamp.firstproject.storage.StorageService;

// @Controller
@RestController
@RequestMapping("/product")
public class ProductController {

    private static Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService prodService;

    @Autowired
    private CategoryService cateService;

    @Autowired
    private StorageService storService;

    public ProductController(ProductService productService, CategoryService categoryService,
            StorageService storageService) {
        super();
        this.prodService = productService;
        this.cateService = categoryService;
        this.storService = storageService;
    }

    // @GetMapping("/")
    @GetMapping("/")
    public String showProduct(Model model) {
        model.addAttribute("isHome", false);
        model.addAttribute("products", prodService.findAllProduct());
        return "modul/product/product.html";
    }

    @GetMapping("/bycategory/{id}")
    public String showProducts(Model model, @PathVariable("id") Long cateId) {
        model.addAttribute("isHome", true);
        model.addAttribute("categories", cateService.findAllCategory());
        model.addAttribute("bycategories", prodService.findProductById(cateId));
        return "modul/product/features-item.html";
    }

    @GetMapping("add")
    public String addProduct(Model model) {
        model.addAttribute("isProduct", true);
        model.addAttribute("action", "Add Product");
        model.addAttribute("product", new Product());
        model.addAttribute("categories", cateService.findAllCategory());
        return "modul/product/addEdit.html";
    }

    // Method Spring MVC
    // @PostMapping("add")
    // public String postProduct(@Valid Product product, BindingResult result,
    //         RedirectAttributes redirectAttrs, @RequestParam("file") MultipartFile file) {
    //     if (result.hasErrors()) {
    //         return "modul/product/addEdit.html";
    //     }
    //     storService.store(file);
    //     prodService.addProduct(product, file.getOriginalFilename());
    //     redirectAttrs.addFlashAttribute("message", "product " + product.getTitle() +
    //             " created.");
    //     return "redirect:/product/";
    // }


    // method REST API
    @PostMapping("add")
    public String postProduct(@RequestBody Product product, BindingResult result,
            RedirectAttributes redirectAttrs) {
        if (result.hasErrors()) {
            return "modul/product/addEdit.html";
        }
        prodService.addProduct(product);
        redirectAttrs.addFlashAttribute("message", "product " + product.getTitle() +
                " created.");
        return "redirect:/product/";
    }

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

        Resource file = storService.loadAsResource(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                .body(file);
    }

    @GetMapping("edit/{id}")
    public String editProductById(@PathVariable("id") Long prodId, Model model) {
        Optional<Product> product = prodService.findProductById(prodId);
        model.addAttribute("isProduct", true);
        model.addAttribute("action", "Edit Product");
        model.addAttribute("product", product);
        model.addAttribute("categories", cateService.findAllCategory());
        return "modul/product/addEdit.html";
    }

    @GetMapping("delete/{id}")
    public String deleteProductById(@PathVariable("id") Long prodId, RedirectAttributes redirectAttrs) {
        prodService.deleteProductById(prodId);
        redirectAttrs.addFlashAttribute("message", "product " + prodId + " deleted.");
        return "redirect:/product/";
    }

    // untuk menghandle error
    @ExceptionHandler(Exception.class)
    public ModelAndView handleError(HttpServletRequest req, Exception ex) {
        logger.error("Product Not Found");
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", ex.getMessage());
        mav.addObject("url", req.getRequestURL());
        mav.setViewName("404");
        return mav;
    }
}

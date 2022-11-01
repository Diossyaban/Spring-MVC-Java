package com.bootcamp.firstproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bootcamp.firstproject.model.Product;

@Service
public interface ProductService {
    
    List<Product> findAllProduct();

    Product addProduct(Product Product, String fileName);

    Product addProduct(Product Product);

    Optional<Product> findProductById(Long cateId);

    void deleteProductById(Long cateId);

    List<Product> findProductByCategoryId(Long cateId);
}

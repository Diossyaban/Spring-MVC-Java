package com.bootcamp.firstproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.firstproject.model.Product;
import com.bootcamp.firstproject.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository prodRepo;

    @Override
    public List<Product> findAllProduct() {
        return prodRepo.findAll();
    }

    @Override
    public Product addProduct(Product product, String fileName) {
        product.setProductImage(fileName);
        return prodRepo.save(product);
    }

    @Override
    public Optional<Product> findProductById(Long prodId) {
        return prodRepo.findById(prodId);
    }

    @Override
    public void deleteProductById(Long prodId) {
        prodRepo.deleteById(prodId);
        
    }

    @Override
    public List<Product> findProductByCategoryId(Long cateId) {
        return prodRepo.findProductByCategoryId(cateId);
    }

    @Override
    public Product addProduct(Product Product) {
        return prodRepo.save(Product);
    }
    
}

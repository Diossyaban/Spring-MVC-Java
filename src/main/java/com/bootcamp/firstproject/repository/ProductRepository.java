package com.bootcamp.firstproject.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bootcamp.firstproject.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
    
    @Query("select p from Product p where p.category.cateId=COALESCE(:cateId,p.category)")
	List<Product> findProductByCategoryId(Long cateId);

	@Query("select p from Product p where p.prodId=:id")
	Optional<Product> findProductById(Long id);
}

package com.tron.springSesson.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tron.springSesson.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	Optional<Product> findByPrdname(String prdname);
 

}

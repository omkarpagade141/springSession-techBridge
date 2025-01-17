package com.tron.springSesson.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tron.springSesson.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

	Optional<Category> findByName(String name);

}

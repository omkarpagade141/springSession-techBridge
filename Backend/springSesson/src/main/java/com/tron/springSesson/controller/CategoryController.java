package com.tron.springSesson.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tron.springSesson.entity.Category;
import com.tron.springSesson.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController 
{
	
	@Autowired
	CategoryService cateservice;
	
	@PostMapping("/addnewcate")
	public ResponseEntity<?> addCategory(@RequestBody Category cate){
		return cateservice.addnewCategotry(cate);
		
	}
	
	
	@PutMapping("/addnewcate/{cateId}")
	public ResponseEntity<?> updateCategory(@RequestBody Category cate, @PathVariable int cateId){
		return cateservice.updateCategory(cate,cateId);
		
	}

}

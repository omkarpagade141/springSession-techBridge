package com.tron.springSesson.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tron.springSesson.entity.Category;
import com.tron.springSesson.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	CategoryRepository caterepo;
	
	
	public ResponseEntity<?> addnewCategotry(Category cate){
		
		Optional<Category> byName = caterepo.findByName(cate.getName());
		if (byName.isPresent()) {
			return new ResponseEntity<>("Category with name "+cate.getName()+ " already exist",HttpStatus.BAD_REQUEST);
			
		}
		LocalDate tod = LocalDate.now();
		cate.setCreatedOn(tod);
		  Category save = caterepo.save(cate);
		  return new ResponseEntity<>(save,HttpStatus.OK);
		
	}


	public ResponseEntity<?> updateCategory(Category cate, int cateId) {
		Optional<Category> byId = caterepo.findById(cateId);
		if (byId.isEmpty()) {
			return new ResponseEntity<>("Category not found",HttpStatus.BAD_REQUEST);
		}
		
		Category existingCategory = byId.get();
		existingCategory.setName(cate.getName());
		
		
		Category save = caterepo.save(existingCategory);
		
		return new ResponseEntity<>(save,HttpStatus.OK);
	}

}

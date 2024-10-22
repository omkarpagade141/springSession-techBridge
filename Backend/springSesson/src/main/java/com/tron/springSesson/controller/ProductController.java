package com.tron.springSesson.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.tron.springSesson.service.ProductService;

@RestController
@RequestMapping("/prooduct")
public class ProductController {
	
	@Autowired
	ProductService prodserv;
	@PostMapping("/addproduct/{cateId}")
	public ResponseEntity<?> addNewProduct(@RequestParam String prdname
			,@RequestParam MultipartFile image,@RequestParam double prdprice,@PathVariable int cateId) throws IOException{
		return prodserv.addNewProduct(prdname, image, prdprice,cateId);
		
	}  
	
	 

}

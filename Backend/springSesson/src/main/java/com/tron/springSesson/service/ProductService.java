package com.tron.springSesson.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.tron.springSesson.entity.Category;
import com.tron.springSesson.entity.Product;
import com.tron.springSesson.repository.CategoryRepository;
import com.tron.springSesson.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	CategoryRepository caterepo;
	@Autowired
	ProductRepository prodrepo;
	
	@Value("${image.upload.folder}")
	private String folderdir;
	
	public ResponseEntity<?> addNewProduct(String prdname,MultipartFile image,double prdprice, int cateId) throws IOException{
		Optional<Category> existingCategory = caterepo.findById(cateId);
		if(existingCategory.isEmpty()) {
			return new ResponseEntity<>("category not found",HttpStatus.BAD_REQUEST);
		}
		
		Optional<Product> byPrdname = prodrepo.findByPrdname(prdname);
		if(byPrdname.isPresent()) {
			return new ResponseEntity<>("product with name "+prdname+ " already exist",HttpStatus.BAD_REQUEST);
		}
		
		Product product= new Product();
		System.out.println(image.getOriginalFilename());
		
		if(!image.isEmpty()) {
			
			long timeMillis = System.currentTimeMillis();
			String uploadpath=folderdir+File.separator+timeMillis+".jpg";
			
			Files.copy(image.getInputStream(), Paths.get(uploadpath), StandardCopyOption.REPLACE_EXISTING);
			 
			LocalDate now = LocalDate.now();
			product.setPrdname(prdname);
			product.setImg(timeMillis+".jpg");
			product.setCreatedOn(now);
			product.setPrdprice(prdprice);
			product.setCategory(existingCategory.get());
			
			Product save = prodrepo.save(product);
			
			return new ResponseEntity<>(save,HttpStatus.OK);
		}else {
			return new ResponseEntity<>("image not found, please select image",HttpStatus.BAD_REQUEST);
		}
		 
		
		
		
	}
	 

}

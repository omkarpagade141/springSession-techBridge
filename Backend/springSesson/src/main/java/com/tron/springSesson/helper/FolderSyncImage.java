package com.tron.springSesson.helper;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class FolderSyncImage {
	
	@Value("${image.upload.folder}")
	private String folderdir;
	
	
	@PostConstruct
	 private void init() {
		File directory= new File(folderdir);
		
		if(!directory.exists()) {
			directory.mkdir();
			System.out.println("image folder created");
		}else {
			System.out.println("images folder already exist");
		}
	}	
}

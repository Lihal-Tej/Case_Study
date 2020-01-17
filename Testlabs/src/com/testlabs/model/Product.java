package com.testlabs.model;

import org.springframework.web.multipart.MultipartFile;

public class Product {
	
	 private String name;
	 
	    private String description;
	 
	    private MultipartFile images;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public MultipartFile getImages() {
			return images;
		}

		public void setImages(MultipartFile images) {
			this.images = images;
		}
	    
	    

}

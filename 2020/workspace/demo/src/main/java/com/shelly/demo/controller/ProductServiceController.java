package com.shelly.demo.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.shelly.demo.exception.ProductNotfoundException;
import com.shelly.demo.model.Product;

@RestController
@CrossOrigin
public class ProductServiceController {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(ProductServiceController.class);
	private static Map<String, Product> productRepo = new HashMap<>();
	   
	static {
	      Product honey = new Product();
	      honey.setId("1");
	      honey.setProductName("Honey");
	      productRepo.put(honey.getId(), honey);
	      
	      Product almond = new Product();
	      almond.setId("2");
	      almond.setProductName("Almond");
	      productRepo.put(almond.getId(), almond);
	   }

	   @GetMapping("/products")
	   public ResponseEntity<Object> getProduct() {
		 
		return ResponseEntity.ok().body(productRepo.values());
	     // return new ResponseEntity<>(productRepo.values(), HttpStatus.OK);
	   }
	   
	   @GetMapping("/all")
	   public Collection<Product> getAllProduct() {
		 
		return productRepo.values();
	   }
	   @PostMapping("/add")
	   public ResponseEntity<Object> createProduct(@RequestBody Product product){
		      productRepo.put(product.getId(), product);
		      return new ResponseEntity("Product is created successfully", HttpStatus.CREATED);
		 
	   }
	   
	   @PutMapping("/update/{id}")
	   public ResponseEntity<Object> updateProduct(@RequestBody Product product, @PathVariable("id") String id){
		   if(!productRepo.containsKey(id)) {
			   LOGGER.info("id not contains -->"+id);
			   throw new ProductNotfoundException();
			   }		   
		   productRepo.remove(id);
		   product.setId(id);
		   productRepo.put(product.getId(), product);
		   return new ResponseEntity("Product is updated successfully", HttpStatus.OK);
	   }
	 @DeleteMapping("/delete/{id}")
	 public ResponseEntity<Object> deleteProduct(@PathVariable("id") String id){
		 productRepo.remove(id);
		 return new ResponseEntity<Object>("Product Deleted Successfully",HttpStatus.OK);
	 }
	 
	 @RequestMapping(value = "/upload", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
		      public String fileUpload(@RequestParam("file") MultipartFile file) throws IOException {
		      File convertFile = new File("C:\\MyGitHub\\Spring-Boot\\2020\\workspace\\demo"+file.getOriginalFilename());
		      convertFile.createNewFile();
		      FileOutputStream fout = new FileOutputStream(convertFile);
		      fout.write(file.getBytes());
		      fout.close();
		      return "File is upload successfully";
		   }
}

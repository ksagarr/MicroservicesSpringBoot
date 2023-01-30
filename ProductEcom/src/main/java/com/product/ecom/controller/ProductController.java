package com.product.ecom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.ecom.entity.Product;
import com.product.ecom.service.ProductServiceImp;

@RestController
@RequestMapping("/api")
public class ProductController {
        @Autowired
	    ProductServiceImp prod;
	    
	    @PostMapping("/save")
		public ResponseEntity<Product> createProduct(@RequestBody Product product ){
			return new ResponseEntity<Product>(prod.saveProduct(product),HttpStatus.OK);
		}
	    @GetMapping("/getall")
		public ResponseEntity<List<Product>> getAllProduct(){
			return new ResponseEntity<List<Product>>(prod.getAllProduct(),HttpStatus.OK);
		}
	    @GetMapping("/get/{prodId}")
	    public ResponseEntity<Product> getProdById(@PathVariable Long prodId){
	    	return new ResponseEntity<Product>(prod.getProductByID(prodId),HttpStatus.OK);
	    }
	    @PostMapping("/list")
	    public ResponseEntity<List<Product>> addListProd(@RequestBody List<Product> product){
	    	 return new ResponseEntity<List<Product>>(prod.saveListProduct(product),HttpStatus.OK);
	    }
	    @PutMapping("/{prodId}")
	    public ResponseEntity<Product> updateProd(@PathVariable Long prodId,@RequestBody Product product){
	    	return new ResponseEntity<Product>(prod.updateProduct(prodId, product),HttpStatus.OK);
	    }
	    @DeleteMapping("/delete/{prodId}")
	    public void deleteProd(@PathVariable Long prodId ) {
	    	prod.deleteProduct(prodId);
	    }
	
	    
	
}

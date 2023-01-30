package com.product.ecom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.product.ecom.entity.Product;
import com.product.ecom.repo.ProdRepository;
@Service
public class ProductServiceImp implements ProductService {
    @Autowired
	ProdRepository repo;
	@Override
	public Product saveProduct(Product product) {
		return repo.save(product);
	}

	@Override
	public List<Product> getAllProduct() {
		return repo.findAll();
	}

	
	@Override
	public Product getProductByID(Long prodId) {
		
		return repo.findById(prodId).get();
	}

	@Override
	public Product updateProduct(Long prodId, Product product) {
		Product productdb=repo.findById(prodId).get();
		productdb.setProdName(product.getProdName());
		productdb.setPrice(product.getPrice());
		return repo.save(productdb);
	}

	@Override
	public void deleteProduct(Long prodId) {
		 repo.deleteById(prodId);
		 System.out.println("Product Sucussful Deleted");
	}

	@Override
	public List<Product> saveListProduct(List<Product> product) {
		return repo.saveAll(product);
	}

}

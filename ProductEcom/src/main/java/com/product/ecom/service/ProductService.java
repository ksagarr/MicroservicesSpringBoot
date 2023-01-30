package com.product.ecom.service;

import java.util.List;
import com.product.ecom.entity.Product;

public interface ProductService {
	public Product saveProduct(Product product);
	public List<Product> getAllProduct();
	public List<Product> saveListProduct(List<Product> product);
	public Product getProductByID(Long prodId);
	public Product updateProduct(Long prodId,Product product);
	public void deleteProduct(Long prodId);
}

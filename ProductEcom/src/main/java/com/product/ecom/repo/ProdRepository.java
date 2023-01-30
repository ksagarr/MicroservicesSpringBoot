package com.product.ecom.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.product.ecom.entity.Product;

public interface ProdRepository extends MongoRepository<Product, Long> {

}

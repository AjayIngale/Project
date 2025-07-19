package com.programmingtechie.product_service.repository;

import com.programmingtechie.product_service.modal.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

}

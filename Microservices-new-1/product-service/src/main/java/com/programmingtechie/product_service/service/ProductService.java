package com.programmingtechie.product_service.service;

import com.programmingtechie.product_service.dto.ProductRequest;
import com.programmingtechie.product_service.dto.ProductResponse;
import com.programmingtechie.product_service.modal.Product;
import com.programmingtechie.product_service.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private  final ProductRepository productRepository;
    public  void  createProduct(@RequestBody ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();
        productRepository.save(product);
        log.info("Product {} created successfully",product.getId());
    }

    public List<ProductResponse> getAllProduct() {
       List<Product>products= productRepository.findAll();
      return  products.stream().map(this::mapTOProductResponse).toList();
    }
    private  ProductResponse  mapTOProductResponse(Product product) {
        return  ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}



package com.tcs.productService.service;

import com.tcs.productService.entity.Product;
import com.tcs.productService.model.ProductRequest;
import com.tcs.productService.model.ProductResponse;

import java.util.List;

public interface ProductService {


    long addProduct(ProductRequest productRequest);

    ProductResponse getProductById(Long id);

    void reduceQuantity(Long productId, long quantity);
}

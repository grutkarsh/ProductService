package com.tcs.productService.service;

import com.tcs.productService.entity.Product;
import com.tcs.productService.exception.ProductServiceCustomException;
import com.tcs.productService.model.ProductRequest;
import com.tcs.productService.model.ProductResponse;
import com.tcs.productService.repository.ProductRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public long addProduct(ProductRequest productRequest) {
        log.info("Adding Product");

        Product product = Product.builder().productName(productRequest.getProductName())
                .price(productRequest.getPrice())
                .quantity(productRequest.getQuantity())
                .build();
        productRepository.save(product);
        log.info("Product Added");
        return product.getProductId();
    }

    @Override
    public ProductResponse getProductById(Long id) {
        log.info("Finding  Product for ID:"+id);
        Product product = productRepository.findById(id).orElseThrow(()-> new ProductServiceCustomException("id not found",HttpStatus.NOT_FOUND.toString()));
        return ProductResponse.builder().productName(product.getProductName())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .productId(product.getProductId())
                .build();
    }

    @Override
    public void reduceQuantity(Long productId, long quantity) {

        log.info("reduced quantity {} for productID {} ",quantity,productId);
        Product product = productRepository
                .findById(productId)
                .orElseThrow(() -> new ProductServiceCustomException("pdid not found ", HttpStatus.NOT_FOUND.toString()));

        if(product.getQuantity() <quantity)
        {
            throw new ProductServiceCustomException("Available quantity is less than required","INCORRECT_QUNATITY");
        }
        long netQuantity= product.getQuantity()-quantity;
        product.setQuantity(netQuantity);
        productRepository.save(product);

    }
}

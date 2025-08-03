package com.tcs.productService.controller;

import com.tcs.productService.entity.Product;
import com.tcs.productService.model.ProductRequest;
import com.tcs.productService.model.ProductResponse;
import com.tcs.productService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping
    public ResponseEntity<Long> addProduct(@RequestBody ProductRequest productRequest)
    {
       long productID= productService.addProduct(productRequest);
       return new ResponseEntity<>(productID, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable Long id)
    {
       ProductResponse productResponse= productService.getProductById(id);
        return new ResponseEntity<>(productResponse,HttpStatus.OK);
    }

    @PutMapping("/reduceQuantity/{id}")
    public ResponseEntity<Void> reduceQuantity(@PathVariable("id") Long productId, @RequestParam long quantity)
    {
      productService.reduceQuantity(productId,quantity);
      return new ResponseEntity<>(HttpStatus.OK);
    }
}

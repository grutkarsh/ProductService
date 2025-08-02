package com.tcs.productService.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long productId;

    @Column(name =" PRODUCT_NAME")
    private String productName;

    @Column(name =" PRICE")
    private Long price;

    @Column(name =" QUANTITY")
    private long quantity;
}

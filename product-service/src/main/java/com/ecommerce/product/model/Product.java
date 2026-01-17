package com.ecommerce.product.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Document(value = "product")
public class Product {

    private String id;
    private String name;
    private String description;
    private BigDecimal price;
}

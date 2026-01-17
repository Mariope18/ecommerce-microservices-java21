package com.ecommerce.product.service;

import com.ecommerce.product.dto.ProductRequest;
import com.ecommerce.product.dto.ProductResponse;
import com.ecommerce.product.mapper.ProductMapper;
import com.ecommerce.product.model.Product;
import com.ecommerce.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductResponse createProduct(ProductRequest request){

        Product product = productMapper.toEntity(request);

        Product savedProduct = productRepository.save(product);

        log.info("Product {} is saved", savedProduct.getId());

        return productMapper.toResponse(savedProduct);
    }

    public List<ProductResponse> getAllProducts(){

        return productRepository.findAll()
                .stream()
                .map(productMapper::toResponse)
                .toList();
    }
}

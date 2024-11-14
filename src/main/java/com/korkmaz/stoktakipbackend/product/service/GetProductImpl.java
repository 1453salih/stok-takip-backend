package com.korkmaz.stoktakipbackend.product.service;

import com.korkmaz.stoktakipbackend.exception.ProductNotFoundException;
import com.korkmaz.stoktakipbackend.product.dto.ProductDto;
import com.korkmaz.stoktakipbackend.product.mapper.ProductMapper;
import com.korkmaz.stoktakipbackend.product.model.Product;
import com.korkmaz.stoktakipbackend.product.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetProductImpl implements GetProductService{
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public GetProductImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public ProductDto getProductById(Long id) {
        return productRepository.findById(id)
                .map(productMapper::toDto)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    @Override
    public ProductDto getProductByCode(String code) {
        return productRepository.findByCode(code)
                .map(productMapper::toDto)
                .orElseThrow(() -> new ProductNotFoundException(code));
    }
}

package com.korkmaz.stoktakipbackend.product.service;

import com.korkmaz.stoktakipbackend.product.dto.ProductDto;
import com.korkmaz.stoktakipbackend.product.mapper.ProductMapper;
import com.korkmaz.stoktakipbackend.product.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class AddProductServiceImpl implements AddProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public AddProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Transactional
    public ProductDto addProduct(ProductDto productDto) {
        return productMapper.toDto(productRepository.save(productMapper.toEntity(productDto)));
    }

}

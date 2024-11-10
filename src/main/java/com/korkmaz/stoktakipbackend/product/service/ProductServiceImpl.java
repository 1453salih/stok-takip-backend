package com.korkmaz.stoktakipbackend.product.service;

import com.korkmaz.stoktakipbackend.product.dto.ProductDto;
import com.korkmaz.stoktakipbackend.product.mapper.ProductMapper;
import com.korkmaz.stoktakipbackend.product.model.Product;
import com.korkmaz.stoktakipbackend.product.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Transactional
    public ProductDto addProduct(ProductDto productDto) {
        Product addProduct = productRepository.save(productMapper.toProduct(productDto));
        return productMapper.toProductDto(addProduct);
    }

}

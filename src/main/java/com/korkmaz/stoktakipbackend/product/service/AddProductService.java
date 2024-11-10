package com.korkmaz.stoktakipbackend.product.service;

import com.korkmaz.stoktakipbackend.product.dto.ProductDto;
import com.korkmaz.stoktakipbackend.product.mapper.ProductMapper;
import com.korkmaz.stoktakipbackend.product.model.Product;
import com.korkmaz.stoktakipbackend.product.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class AddProductService implements ProductService{

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public AddProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public ProductDto addProduct(ProductDto productDto) {
        Product product = productMapper.toProduct(productDto);
        Product addProduct = productRepository.save(product);

        return productMapper.toProductDto(addProduct);
    }
}

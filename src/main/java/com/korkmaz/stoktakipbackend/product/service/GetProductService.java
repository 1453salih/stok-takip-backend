package com.korkmaz.stoktakipbackend.product.service;

import com.korkmaz.stoktakipbackend.product.dto.ProductDto;

public interface GetProductService {
    ProductDto getProductById(Long id);
    ProductDto getProductByCode(String code);
}

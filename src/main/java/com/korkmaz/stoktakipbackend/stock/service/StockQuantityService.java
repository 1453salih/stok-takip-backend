package com.korkmaz.stoktakipbackend.stock.service;

import com.korkmaz.stoktakipbackend.product.dto.ProductDto;

import java.util.Optional;

public interface StockQuantityService {
    Optional<Integer> getStockQuantity(Long productId);
}

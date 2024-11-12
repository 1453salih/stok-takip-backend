package com.korkmaz.stoktakipbackend.stock.service;

import com.korkmaz.stoktakipbackend.product.dto.ProductDto;

public interface StockCheckService {
    boolean isStockRegistered(Long productId);
}

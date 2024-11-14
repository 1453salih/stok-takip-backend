package com.korkmaz.stoktakipbackend.stock.service;
import java.util.Optional;


public interface StockQuantityService {
    Optional<Integer> getStockQuantity(Long productId);
}

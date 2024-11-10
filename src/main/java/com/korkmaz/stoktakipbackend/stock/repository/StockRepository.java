package com.korkmaz.stoktakipbackend.stock.repository;

import com.korkmaz.stoktakipbackend.stock.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StockRepository extends JpaRepository<Stock, Integer> {
    Optional<Stock> findByProductId(Long productId);
}

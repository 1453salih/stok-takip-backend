package com.korkmaz.stoktakipbackend.stock.service;
import com.korkmaz.stoktakipbackend.stock.model.Stock;
import com.korkmaz.stoktakipbackend.stock.repository.StockRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StockQuantityServiceImpl implements StockQuantityService {

    private final StockRepository stockRepository;

    public StockQuantityServiceImpl(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Override
    public Optional<Integer> getStockQuantity(Long productId) {
        return stockRepository.findByProductId(productId).map(Stock::getQuantity);
    }
}

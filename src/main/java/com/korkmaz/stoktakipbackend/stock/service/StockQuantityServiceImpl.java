package com.korkmaz.stoktakipbackend.stock.service;

import com.korkmaz.stoktakipbackend.product.dto.ProductDto;
import com.korkmaz.stoktakipbackend.product.mapper.ProductMapper;
import com.korkmaz.stoktakipbackend.stock.model.Stock;
import com.korkmaz.stoktakipbackend.stock.repository.StockRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StockQuantityServiceImpl implements StockQuantityService {

    private final StockRepository stockRepository;
    private final ProductMapper productMapper;

    public StockQuantityServiceImpl(StockRepository stockRepository, ProductMapper productMapper) {
        this.stockRepository = stockRepository;
        this.productMapper = productMapper;
    }

    @Override
    public Optional<Integer> getStockQuantity(Long productId) {
        return stockRepository.findByProductId(productId).map(Stock::getQuantity);
    }
}

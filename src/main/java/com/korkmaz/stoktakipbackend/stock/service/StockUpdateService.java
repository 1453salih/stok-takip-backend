package com.korkmaz.stoktakipbackend.stock.service;

import com.korkmaz.stoktakipbackend.product.repository.ProductRepository;
import org.springframework.stereotype.Service;


@Service
public class StockUpdateService implements StockService {

    private final ProductRepository productRepository;

    public StockUpdateService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void updateStock(Long productId, int quantity) {
     return;
    }
}

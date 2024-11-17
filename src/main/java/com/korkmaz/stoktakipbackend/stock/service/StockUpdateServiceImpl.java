package com.korkmaz.stoktakipbackend.stock.service;

import com.korkmaz.stoktakipbackend.stock.model.Stock;
import com.korkmaz.stoktakipbackend.stock.repository.StockRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
@Service
public class StockUpdateServiceImpl implements StockUpdateService {
    private final StockRepository stockRepository;


    public StockUpdateServiceImpl(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Transactional
    @Override
    public void updateStock(Long productId ,int quantity) {
        Stock stock =stockRepository.findByProductId(productId)
                .orElseThrow(()->new IllegalArgumentException("Ürün bulunamadı: "+productId ));

        int newQuantity =stock.getQuantity() - quantity;

        stock.setQuantity(newQuantity);

        stockRepository.save(stock);
    }
}

package com.korkmaz.stoktakipbackend.stock.service;
import com.korkmaz.stoktakipbackend.stock.repository.StockRepository;
import org.springframework.stereotype.Service;

@Service
public class StockCheckServiceImpl implements StockCheckService{

    private final StockRepository stockRepository;

    public StockCheckServiceImpl(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Override
    public boolean isStockRegistered(Long productId){
        return stockRepository.findByProductId(productId).isPresent();
    }

}

package com.korkmaz.stoktakipbackend.sale.service;

import com.korkmaz.stoktakipbackend.sale.dto.SaleDto;
import com.korkmaz.stoktakipbackend.sale.mapper.SaleMapper;
import com.korkmaz.stoktakipbackend.sale.model.Sale;
import com.korkmaz.stoktakipbackend.sale.repository.SaleRepository;
import com.korkmaz.stoktakipbackend.stock.service.StockCheckService;
import com.korkmaz.stoktakipbackend.stock.service.StockQuantityService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleServiceImpl implements SaleService {

    private final SaleRepository saleRepository;
    private final SaleMapper saleMapper;
    private final StockCheckService stockCheckService;
    private final StockQuantityService stockQuantityService;



    @Autowired
    public SaleServiceImpl(SaleRepository saleRepository, SaleMapper saleMapper, StockCheckService stockCheckService, StockQuantityService stockQuantityService) {
        this.saleRepository = saleRepository;
        this.saleMapper = saleMapper;
        this.stockCheckService = stockCheckService;
        this.stockQuantityService = stockQuantityService;
    }

    @Override
    @Transactional
    public SaleDto saveSale(SaleDto saleDto) {

        Long productId = saleDto.getProductId();

        if(!stockCheckService.isStockRegistered(productId)){
            throw new IllegalArgumentException("ürün stoğu bulunamadı.");
        }

        int stockQuantity = stockQuantityService.getStockQuantity(productId)
                .orElseThrow(() -> new IllegalArgumentException("Ürün stoğu bulunamadı."));

        if (stockQuantity < saleDto.getQuantity()) {
            throw new IllegalArgumentException("Yeterli stok yok");
        }

        Sale sale = saleMapper.toSale(saleDto);
        Sale savedSale = saleRepository.save(sale);
        return saleMapper.toSaleDto(savedSale);
    }

}

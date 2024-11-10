package com.korkmaz.stoktakipbackend.sale.service;

import com.korkmaz.stoktakipbackend.sale.dto.SaleDto;
import com.korkmaz.stoktakipbackend.sale.mapper.SaleMapper;
import com.korkmaz.stoktakipbackend.sale.model.Sale;
import com.korkmaz.stoktakipbackend.sale.repository.SaleRepository;
import com.korkmaz.stoktakipbackend.stock.model.Stock;
import com.korkmaz.stoktakipbackend.stock.repository.StockRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleServiceImpl implements SaleService {

    private final SaleRepository saleRepository;
    private final StockRepository stockRepository;
    private final SaleMapper saleMapper;

    @Autowired
    public SaleServiceImpl(SaleRepository saleRepository, StockRepository stockRepository, SaleMapper saleMapper) {
        this.saleRepository = saleRepository;
        this.stockRepository = stockRepository;
        this.saleMapper = saleMapper;
    }

    @Override
    @Transactional
    public SaleDto saveSale(SaleDto saleDto) {
        Sale sale = saleMapper.toSale(saleDto);

        Stock stock = stockRepository.findByProductId(sale.getProduct().getId())
                .orElseThrow(() -> new IllegalArgumentException("Ürün stoğu bulunamadı"));

        if (stock.getQuantity() > saleDto.getQuantity()) {
            throw new IllegalArgumentException("Yeterli stok yok");
        }

        stock.setQuantity(stock.getQuantity()-saleDto.getQuantity());
        stockRepository.save(stock);

        Sale saveSale = saleRepository.save(sale);

        return saleMapper.toSaleDto(saveSale);
    }

}

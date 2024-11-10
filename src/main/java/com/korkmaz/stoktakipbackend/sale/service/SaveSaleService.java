package com.korkmaz.stoktakipbackend.sale.service;

import com.korkmaz.stoktakipbackend.sale.dto.SaleDto;
import com.korkmaz.stoktakipbackend.sale.mapper.SaleMapper;
import com.korkmaz.stoktakipbackend.sale.model.Sale;
import com.korkmaz.stoktakipbackend.sale.repository.SaleRepository;
import com.korkmaz.stoktakipbackend.stock.service.StockService;
import org.springframework.stereotype.Service;


@Service
public class SaveSaleService implements SaleService {
    private final SaleRepository saleRepository;
    private final SaleMapper saleMapper;
    private final StockService stockService;

    public SaveSaleService(SaleRepository saleRepository, SaleMapper saleMapper, StockService stockService) {
        this.saleRepository = saleRepository;
        this.saleMapper = saleMapper;
        this.stockService = stockService;
    }

    public SaleDto saveSale(SaleDto saleDto) {
        Sale sale = saleMapper.toSale(saleDto);
        Sale savedSale = saleRepository.save(sale);

        stockService.updateStock(sale.getProduct().getId(),sale.getQuantity());

        return saleMapper.toSaleDto(savedSale);
    }
}

package com.korkmaz.stoktakipbackend.sale.service;

import com.korkmaz.stoktakipbackend.sale.dto.SaleDto;
import com.korkmaz.stoktakipbackend.sale.mapper.SaleMapper;
import com.korkmaz.stoktakipbackend.sale.model.Sale;
import com.korkmaz.stoktakipbackend.sale.repository.SaleRepository;
import com.korkmaz.stoktakipbackend.stock.service.StockUpdateService;
import org.springframework.stereotype.Service;


@Service
public class SaveSaleService implements SaleService {
    private final SaleRepository saleRepository;
    private final SaleMapper saleMapper;
    private final StockUpdateService stockUpdateService;

    public SaveSaleService(SaleRepository saleRepository, SaleMapper saleMapper, StockUpdateService stockUpdateService) {
        this.saleRepository = saleRepository;
        this.saleMapper = saleMapper;

        this.stockUpdateService = stockUpdateService;
    }

    public SaleDto saveSale(SaleDto saleDto) {
        Sale sale = saleMapper.toSale(saleDto);
        Sale savedSale = saleRepository.save(sale);

        stockUpdateService.updateStock(sale.getProduct().getId(),sale.getQuantity());

        return saleMapper.toSaleDto(savedSale);
    }
}

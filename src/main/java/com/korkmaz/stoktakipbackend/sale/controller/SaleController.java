package com.korkmaz.stoktakipbackend.sale.controller;

import com.korkmaz.stoktakipbackend.sale.dto.SaleDto;
import com.korkmaz.stoktakipbackend.sale.service.SaveSaleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/sale")
public class SaleController {

    private final SaveSaleService saveSaleService;

    public SaleController(SaveSaleService saveSaleService) {
        this.saveSaleService = saveSaleService;
    }

    @PostMapping
    public ResponseEntity<SaleDto> saveSale(@RequestBody SaleDto saleDto) {
        SaleDto createdSale = saveSaleService.saveSale(saleDto);
        return new ResponseEntity<>(createdSale, HttpStatus.CREATED);
    }
}

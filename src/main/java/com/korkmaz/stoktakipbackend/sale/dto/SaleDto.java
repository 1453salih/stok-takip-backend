package com.korkmaz.stoktakipbackend.sale.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class SaleDto {
    private Long id;
    private Long listNo;
    private Long productId;
    private Long customerId;
    private int quantity;
    private BigDecimal price;
    private BigDecimal discount;
    private BigDecimal vat;
    private BigDecimal totalPrice;
}

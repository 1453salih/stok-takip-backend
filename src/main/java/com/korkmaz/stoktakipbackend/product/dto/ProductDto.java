package com.korkmaz.stoktakipbackend.product.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    private Long id;
    private String code;
    private String name;
    private BigDecimal priceOne;
    private BigDecimal priceTwo;
    private BigDecimal priceThree;
    private int categoryId;
}

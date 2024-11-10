package com.korkmaz.stoktakipbackend.product.dto;

import com.korkmaz.stoktakipbackend.productcategories.model.ProductCategories;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    private Long id;
    private Long code;
    private String name;
    private BigDecimal priceOne;
    private BigDecimal priceTwo;
    private BigDecimal priceThree;
    private ProductCategories category;
}

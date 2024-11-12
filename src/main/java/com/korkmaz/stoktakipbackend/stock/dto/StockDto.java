package com.korkmaz.stoktakipbackend.stock.dto;

import com.korkmaz.stoktakipbackend.product.dto.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StockDto {
    private int id;
    private ProductDto product;
    private int quantity;
}

// Dto'lar özelleştirilmeli gerekesiz veri taşıyanlar iptal edilmeli.
// Örneğin ProductDto nesnesi şuanki kullanımlarda gereksiz veri yükü mevcut product_id yeterli olabilir.
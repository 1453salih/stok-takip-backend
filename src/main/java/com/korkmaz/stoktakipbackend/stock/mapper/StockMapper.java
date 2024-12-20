package com.korkmaz.stoktakipbackend.stock.mapper;

import com.korkmaz.stoktakipbackend.stock.dto.StockDto;
import com.korkmaz.stoktakipbackend.stock.model.Stock;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StockMapper {

    @Mapping(source = "product.id", target = "productId")
    StockDto toDto(Stock stock);

    @Mapping(source = "productId", target = "product.id")
    Stock toEntity(StockDto stockDto);
}

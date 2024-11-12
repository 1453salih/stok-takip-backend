package com.korkmaz.stoktakipbackend.stock.mapper;

import com.korkmaz.stoktakipbackend.stock.dto.StockDto;
import com.korkmaz.stoktakipbackend.stock.model.Stock;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface StockMapper {

    @Mapping(source = "product", target = "product")
    StockDto toDto(Stock stock);

    @Mapping(source = "product", target = "product")
    Stock toEntity(StockDto stockDto);
}

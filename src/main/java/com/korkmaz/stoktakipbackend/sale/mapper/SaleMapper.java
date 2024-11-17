package com.korkmaz.stoktakipbackend.sale.mapper;

import com.korkmaz.stoktakipbackend.sale.dto.SaleDto;
import com.korkmaz.stoktakipbackend.sale.model.Sale;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface SaleMapper {

    @Mapping(source = "product.id", target = "productId")
    @Mapping(source = "customer.id", target = "customerId")
    SaleDto toDto(Sale sale);

    @Mapping(source = "productId", target = "product.id")
    @Mapping(source = "customerId", target = "customer.id")
    Sale toEntity(SaleDto saleDto);
}

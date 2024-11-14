package com.korkmaz.stoktakipbackend.customer.mapper;


import com.korkmaz.stoktakipbackend.customer.dto.CustomerDto;
import com.korkmaz.stoktakipbackend.customer.model.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerDto toDto(Customer customer);

    Customer toEntity(CustomerDto customerDto);

}

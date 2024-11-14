package com.korkmaz.stoktakipbackend.customer.service;

import com.korkmaz.stoktakipbackend.customer.dto.CustomerDto;

public interface AddCustomerService {
    CustomerDto addCustomer(CustomerDto customerDto);
}

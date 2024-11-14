package com.korkmaz.stoktakipbackend.customer.service;

import com.korkmaz.stoktakipbackend.customer.dto.CustomerDto;
import com.korkmaz.stoktakipbackend.customer.mapper.CustomerMapper;
import com.korkmaz.stoktakipbackend.customer.model.Customer;
import com.korkmaz.stoktakipbackend.customer.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class AddCustomerServiceImpl implements AddCustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public AddCustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    public CustomerDto addCustomer(CustomerDto customerDto) {
        Customer customer = customerMapper.toEntity(customerDto);
        Customer addCustomer = customerRepository.save(customer);

        return customerMapper.toDto(addCustomer);
    }
}

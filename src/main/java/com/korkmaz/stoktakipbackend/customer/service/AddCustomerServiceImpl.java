package com.korkmaz.stoktakipbackend.customer.service;

import com.korkmaz.stoktakipbackend.customer.dto.CustomerDto;
import com.korkmaz.stoktakipbackend.customer.mapper.CustomerMapper;
import com.korkmaz.stoktakipbackend.customer.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class AddCustomerServiceImpl implements AddCustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public AddCustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Transactional
    @Override
    public CustomerDto addCustomer(CustomerDto customerDto) {
        return customerMapper.toDto(customerRepository.save(customerMapper.toEntity(customerDto)));
    }
}

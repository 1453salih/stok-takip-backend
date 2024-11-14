package com.korkmaz.stoktakipbackend.customer.controller;


import com.korkmaz.stoktakipbackend.customer.dto.CustomerDto;
import com.korkmaz.stoktakipbackend.customer.service.AddCustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    private final AddCustomerService addCustomerService;

    public CustomerController(AddCustomerService addCustomerService) {
        this.addCustomerService = addCustomerService;
    }

    @PostMapping("/add")
    public ResponseEntity<CustomerDto> addCustomer(@RequestBody CustomerDto customerDto) {
        CustomerDto createdCustomer = addCustomerService.addCustomer(customerDto);
        return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);
    }
}

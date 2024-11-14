package com.korkmaz.stoktakipbackend.customer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {
    private int id;
    private String companyName;
    private String customerCode;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
}

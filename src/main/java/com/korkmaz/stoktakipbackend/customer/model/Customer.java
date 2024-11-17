package com.korkmaz.stoktakipbackend.customer.model;

import com.korkmaz.stoktakipbackend.sale.model.Sale;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String companyName;

    @Column(unique = true)
    private String customerCode;

    @Column(nullable = false,length = 10)
    private String firstName;

    @Column(length = 30)
    private String lastName;

    @Column(length = 50)
    private String email;

    @Column(length = 15)
    private String phone;

    private String address;

    @OneToMany(mappedBy = "customer")
    private Set<Sale> sale;

}

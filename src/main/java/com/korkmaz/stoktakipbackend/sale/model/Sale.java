package com.korkmaz.stoktakipbackend.sale.model;


import com.korkmaz.stoktakipbackend.customer.model.Customer;
import com.korkmaz.stoktakipbackend.product.model.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sale")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long listNo;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false, precision = 10 , scale = 2)
    private BigDecimal price;

    @Column(nullable = false, precision = 5, scale =2)
    private BigDecimal discount;

    @Column(nullable = false, precision = 5 , scale = 2)
    private BigDecimal vat;

    @Column(precision = 10 , scale = 2)
    private BigDecimal totalPrice;
}

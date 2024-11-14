package com.korkmaz.stoktakipbackend.product.model;


import com.korkmaz.stoktakipbackend.productcategories.model.ProductCategories;
import com.korkmaz.stoktakipbackend.transactionhistory.model.ProductTransactionHistory;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String code;

    @Column(nullable = false,length = 50)
    private String name;

    @Column(precision = 10, scale = 2,nullable = false)//* örn: 12345678.12
    private BigDecimal priceOne;

    @Column(precision = 10, scale = 2)
    private BigDecimal priceTwo;

    @Column(precision = 10, scale = 2)
    private BigDecimal priceThree;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private ProductCategories category;

    @OneToOne(mappedBy = "product",cascade = CascadeType.ALL)
    private ProductTransactionHistory productTransactionHistory;
}

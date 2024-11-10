package com.korkmaz.stoktakipbackend.transactionhistory.model;

import com.korkmaz.stoktakipbackend.product.model.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product_transaction_history")
public class ProductTransactionHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    private Product product;

    @Column(name = "last_purchase_date")
    private LocalDate lastPurchaseDate;

    @Column(name="last_sale_date")
    private LocalDate lastSaleDate;

    @Column(name = "last_purchase_price", precision = 10, scale = 2)
    private BigDecimal lastPurchasePrice;

    @Column(name="last_sale_price", precision = 10, scale = 2)
    private BigDecimal lastSalePrice;

}

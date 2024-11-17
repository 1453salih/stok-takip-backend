package com.korkmaz.stoktakipbackend.category.model;

import com.korkmaz.stoktakipbackend.product.model.Product;
import jakarta.persistence.*;
import lombok.Data;


import java.util.Set;
@Table(name = "product_categories")
@Data
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    //? Set kullanılmasındaki sebep tekrar eden elemanlara izin vermez ve hızlı sıralama işim yok
    private Set<Product> product;
}

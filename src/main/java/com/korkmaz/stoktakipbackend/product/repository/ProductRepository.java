package com.korkmaz.stoktakipbackend.product.repository;

import com.korkmaz.stoktakipbackend.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product,Long> {
}

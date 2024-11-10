package com.korkmaz.stoktakipbackend.sale.repository;

import com.korkmaz.stoktakipbackend.sale.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale,Long> {

}

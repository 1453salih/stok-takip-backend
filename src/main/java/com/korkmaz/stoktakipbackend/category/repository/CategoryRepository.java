package com.korkmaz.stoktakipbackend.category.repository;

import com.korkmaz.stoktakipbackend.category.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}

package com.korkmaz.stoktakipbackend.category.controller;

import com.korkmaz.stoktakipbackend.category.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryRepository categoryRepository;


}

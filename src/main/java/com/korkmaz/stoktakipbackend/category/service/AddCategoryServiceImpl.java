package com.korkmaz.stoktakipbackend.category.service;

import com.korkmaz.stoktakipbackend.category.dto.CategoryDto;
import com.korkmaz.stoktakipbackend.category.mapper.CategoryMapper;

import com.korkmaz.stoktakipbackend.category.repository.CategoryRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

@Service
public class AddCategoryServiceImpl implements AddCategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public AddCategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }
    @Transactional
    @Override
    public CategoryDto addCategory(CategoryDto categoryDto) {
        return categoryMapper.toDto(categoryRepository.save(categoryMapper.toEntity(categoryDto)));
    }

}

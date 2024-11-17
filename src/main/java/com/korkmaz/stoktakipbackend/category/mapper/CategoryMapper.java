package com.korkmaz.stoktakipbackend.category.mapper;

import com.korkmaz.stoktakipbackend.category.dto.CategoryDto;
import com.korkmaz.stoktakipbackend.category.model.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryDto toDto(Category category);
    Category toEntity(CategoryDto dto);
}

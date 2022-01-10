package com.moneymanagerapp.mapper;

import com.moneymanagerapp.domain.Category;
import com.moneymanagerapp.domain.enums.CategoryType;
import com.moneymanagerapp.dto.CategoryDto;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BusinessMapper {
    public CategoryDto toCategoryDto(Category category) {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(category.getId());
        categoryDto.setTitle(category.getTitle());
        categoryDto.setCategoryType(category.getCategoryType().toString());
        categoryDto.setLocalDate(category.getLocalDate().toString());
        return categoryDto;
    }

    public List<CategoryDto> toCategoryDtoList(List<Category> categoryList) {
        return categoryList.stream().map(this::toCategoryDto).collect(Collectors.toList());
    }

    public Category toCategoryEntity(CategoryDto categoryDto) {
        Category category = new Category();
        category.setId(categoryDto.getId());
        category.setTitle(categoryDto.getTitle());
        category.setCategoryType(CategoryType.valueOf(categoryDto.getCategoryType()));
        category.setLocalDate(LocalDate.parse(categoryDto.getLocalDate()));
        return category;
    }
}

package com.moneymanagerapp.mapper;

import com.moneymanagerapp.domain.Category;
import com.moneymanagerapp.domain.User;
import com.moneymanagerapp.domain.enums.CategoryType;
import com.moneymanagerapp.dto.CategoryDto;
import com.moneymanagerapp.dto.RoleDto;
import com.moneymanagerapp.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class BusinessMapper {

    public CategoryDto toCategoryDto(Category category) {
        return CategoryDto.builder()
                .id(category.getId())
                .title(category.getTitle())
                .categoryType(category.getCategoryType().toString())
                .localDate(category.getLocalDate().toString())
                .build();
    }

    public List<CategoryDto> toCategoryDtoList(List<Category> categoryList) {
        return categoryList.stream()
                .map(this::toCategoryDto)
                .collect(Collectors.toList());
    }

    public Category toCategoryEntity(CategoryDto categoryDto) {
        return Category.builder()
                .id(categoryDto.getId())
                .title(categoryDto.getTitle())
                .categoryType(CategoryType.valueOf(categoryDto.getCategoryType()))
                .localDate(LocalDate.parse(categoryDto.getLocalDate()))
                .build();
    }
}

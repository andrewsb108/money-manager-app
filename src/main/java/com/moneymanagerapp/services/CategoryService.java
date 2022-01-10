package com.moneymanagerapp.services;

import com.moneymanagerapp.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> getAll();
    String createCategory(CategoryDto categoryDto);
    CategoryDto updateCategory(CategoryDto categoryDto);
    void deleteById(int id);
    CategoryDto getById(int id);

}

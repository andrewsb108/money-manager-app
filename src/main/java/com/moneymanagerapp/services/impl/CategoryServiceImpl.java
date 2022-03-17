package com.moneymanagerapp.services.impl;

import com.moneymanagerapp.domain.Category;
import com.moneymanagerapp.dto.CategoryDto;
import com.moneymanagerapp.exceptions.CategoryAlreadyExistException;
import com.moneymanagerapp.mapper.BusinessMapper;
import com.moneymanagerapp.repository.CategoryRepository;
import com.moneymanagerapp.services.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    private static final String CATEGORY_ALREADY_CREATED = "Category already created";

    private final CategoryRepository categoryRepository;
    private final BusinessMapper mapper;

    @Override
    public List<CategoryDto> getAll() {
        List<Category> findAll = categoryRepository.findAll();

        return mapper.toCategoryDtoList(findAll);
    }

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        try {
            Category category = mapper.toCategoryEntity(categoryDto);
            log.info("Created category " + category);
            Category savedCategory = categoryRepository.save(category);
            return mapper.toCategoryDto(savedCategory);
        } catch (Exception e) {
            log.info("Category already created {}", e.getMessage());
            throw new CategoryAlreadyExistException(CATEGORY_ALREADY_CREATED);
        }
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto) {
        Category categoryCheckIfIdExist = categoryRepository.findById(categoryDto.getId())
                .orElseThrow(() -> new NoSuchElementException("No such category with id: " + categoryDto.getId()));
        String oldTitle = categoryCheckIfIdExist.getTitle();

        Category category = mapper.toCategoryEntity(categoryDto);
        log.info("Category {} was modified to {}", oldTitle, categoryDto.getTitle());
        categoryRepository.save(category);
        return mapper.toCategoryDto(category);
    }

    @Override
    public void deleteById(int id) {
        try {
            categoryRepository.deleteById(id);
        } catch (NoSuchElementException e) {
            log.info("Deleted category with id: " + id);
        }
    }

    @Override
    public CategoryDto getById(int id) {
        return mapper.toCategoryDto(categoryRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("No such category was found, id: " + id)));
    }
}

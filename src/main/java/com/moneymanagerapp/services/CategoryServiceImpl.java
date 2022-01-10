package com.moneymanagerapp.services;

import com.moneymanagerapp.domain.Category;
import com.moneymanagerapp.dto.CategoryDto;
import com.moneymanagerapp.mapper.BusinessMapper;
import com.moneymanagerapp.repository.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import javax.annotation.Resource;

@Slf4j
@Service
public class CategoryServiceImpl implements CategoryService {
    @Resource
    private CategoryRepository categoryRepository;

    @Resource
    private BusinessMapper mapper;

    @Override
    public List<CategoryDto> getAll() {
        List<Category> findAll = categoryRepository.findAll();

        return mapper.toCategoryDtoList(findAll);
    }

    @Override
    public String createCategory(CategoryDto categoryDto) {
        Category category = mapper.toCategoryEntity(categoryDto);
        Category savedCategory = categoryRepository.save(category);

        return savedCategory.getId() != 0 ? "Created" : "Not created";
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

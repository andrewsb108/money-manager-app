package com.moneymanagerapp.controllers;

import com.moneymanagerapp.dto.CategoryDto;
import com.moneymanagerapp.services.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/all")
    public ResponseEntity<List<CategoryDto>> getAllCategories() {
        List<CategoryDto> getAllCategories = categoryService.getAll();
        return new ResponseEntity<>(getAllCategories, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto) {

        CategoryDto dto = categoryService.createCategory(categoryDto);
        log.info("Category was created");

        return new ResponseEntity<>(dto, HttpStatus.OK);

    }

    @PostMapping("/update")
    public String updateCategory(@RequestBody CategoryDto categoryDto) {
        categoryService.updateCategory(categoryDto);
        return "";
    }

    @GetMapping("/delete/{id}")
    public void deleteCategory(@PathVariable("id") int id) {
        categoryService.deleteById(id);
    }

    @GetMapping("getById")
    public CategoryDto getById(int id) {
        return categoryService.getById(id);
    }
}

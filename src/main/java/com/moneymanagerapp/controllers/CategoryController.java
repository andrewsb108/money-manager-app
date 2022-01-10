package com.moneymanagerapp.controllers;

import com.moneymanagerapp.dto.CategoryDto;
import com.moneymanagerapp.services.CategoryService;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import javax.annotation.Resource;

@Log4j2
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Resource
    private CategoryService categoryService;

    @GetMapping("/all")
    public List<CategoryDto> getAllCategories() {
        return categoryService.getAll();
    }

    @PostMapping("/create")
    public String createCategory(@RequestBody CategoryDto categoryDto) {
        categoryService.createCategory(categoryDto);
        return "";
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

package com.moneymanagerapp.repository;

import com.moneymanagerapp.domain.Category;
import com.moneymanagerapp.domain.enums.CategoryType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    List<Category> findAllByCategoryType(CategoryType categoryType);
}

package com.moneymanagerapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryDto {

    private int id;

    @NotNull
    @NotBlank(message = "Title is not filed")
    @Size(min = 5, max = 200, message= "About Me must be between 5 and 200 characters")
    private String title;

    @NotNull
    @NotBlank(message = "CategoryType is not filed")
    private String categoryType;

    @NotBlank(message = "LocalDate is not filed")
    private String localDate;
}

package com.example.BlogApplication.service;

import com.example.BlogApplication.payloads.CategoryDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService{
     //create

    CategoryDto createCategory(CategoryDto categoryDto);

    //update

    CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);

    //delete

    void deleteCategory(Integer categoryId);

    //get

    CategoryDto getCategory(Integer categoryId);

    //getAll

    List<CategoryDto>getCategories();

}

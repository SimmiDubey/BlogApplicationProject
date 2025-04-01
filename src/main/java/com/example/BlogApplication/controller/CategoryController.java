package com.example.BlogApplication.controller;

import com.example.BlogApplication.payloads.ApiResponse;
import com.example.BlogApplication.payloads.CategoryDto;
import com.example.BlogApplication.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

     @Autowired
    private CategoryService categoryService;
    //create

    @PostMapping
      public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto){
          CategoryDto createCategory = this.categoryService.createCategory(categoryDto);
          return new ResponseEntity<CategoryDto>(createCategory, HttpStatus.CREATED);
      }

    //update

    @PutMapping("/catId")
    public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto categoryDto,@PathVariable Integer catId){
       CategoryDto updateCategory = this.categoryService.updateCategory(categoryDto,catId);
        return new ResponseEntity<CategoryDto>(updateCategory,HttpStatus.OK);
    }

    //delete

      @DeleteMapping("/catId")
     public ResponseEntity<ApiResponse>deleteCategory(@PathVariable Integer catId){
        this.categoryService.deleteCategory(catId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("Category is deleted successfully",true),HttpStatus.OK);

      }

    //get

    @GetMapping("/catId")
    public ResponseEntity<CategoryDto> getCategory(@PathVariable Integer catId){
      CategoryDto categoryDto = this.categoryService.getCategory(catId);
        return new ResponseEntity<CategoryDto>(categoryDto,HttpStatus.OK);

    }

    //getAll

    @GetMapping("/")
    public ResponseEntity<List<CategoryDto>>getCategories(@RequestBody CategoryDto categoryDto){
       List<CategoryDto> categories= this.categoryService.getCategories();
        return ResponseEntity.ok(categories);

    }


}

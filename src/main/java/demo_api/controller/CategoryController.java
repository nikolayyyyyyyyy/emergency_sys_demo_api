package demo_api.controller;

import demo_api.models.Category;
import demo_api.services.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController{
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @GetMapping("{id}")
    public Category getCategory(@PathVariable("id")Long id){
        return this.categoryService.getCategory(id);
    }

    @PostMapping
    public String createCategory(@RequestBody Category category){
        this.categoryService.createCategory(category);
        return "Category created!";
    }

    @GetMapping
    public List<Category> getAllCategories(){
        return this.categoryService.getAllCategories();
    }
}

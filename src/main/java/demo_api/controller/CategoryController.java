package demo_api.controller;

import demo_api.models.Category;
import demo_api.models.dto.CategoryDTO;
import demo_api.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController{
    private final CategoryService categoryService;
    private final ModelMapper modelMapper = new ModelMapper();

    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @GetMapping("{id}")
    public CategoryDTO getCategory(@PathVariable("id")Long id){
        return modelMapper.map(this.categoryService.getCategory(id),CategoryDTO.class);
    }

    @PostMapping
    public String createCategory(@RequestBody CategoryDTO category){
        Category createdCategory = new Category();
        createdCategory.setCategoryType(category.getCategoryType());

        this.categoryService.createCategory(createdCategory);
        return "Category created!";
    }

    @GetMapping
    public List<CategoryDTO> getAllCategories(){
        return this.categoryService
                .getAllCategories()
                .stream()
                .map(c -> modelMapper.map(c,CategoryDTO.class)).toList();
    }
}

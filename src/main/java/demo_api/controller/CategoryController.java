package demo_api.controller;
import demo_api.exception.EntityAlreadyAddedInDatabase;
import demo_api.exception.EntityNotFoundException;
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
    private final ModelMapper modelMapper;

    public CategoryController(CategoryService categoryService,
                            ModelMapper modelMapper){

        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("{id}")
    public CategoryDTO getCategory(@PathVariable("id")Long id){
        Category category = this.categoryService.getCategory(id);
        if(category == null){
            throw new EntityNotFoundException("Category does not exist in the database!");
        }

        return modelMapper.map(this.categoryService.getCategory(id),CategoryDTO.class);
    }

    @PostMapping
    public String createCategory(@RequestBody CategoryDTO category){
        if(this.categoryService.hasCategory(category.getCategoryType())){

            throw new EntityAlreadyAddedInDatabase("Category already added!");
        }
        this.categoryService.createCategory(this.modelMapper.map(category,Category.class));
        return "Category created!";
    }

    @GetMapping
    public List<CategoryDTO> getAllCategories(){
        List<Category> categories = this.categoryService.getAllCategories();
        if(categories == null){
            throw new EntityNotFoundException("Category table is empty!");
        }

        return this.categoryService
                .getAllCategories()
                .stream()
                .map(c -> modelMapper.map(c,CategoryDTO.class)).toList();
    }

    @DeleteMapping("{id}")
    public String deleteCategory(@PathVariable(name = "id")long id){
        Category category = this.categoryService.getCategory(id);
        if(category == null){
            throw new EntityNotFoundException("Category does not exist in the database!");
        }

        this.categoryService.deleteCategory(id);
        return "Category deleted successfully!";
    }
}

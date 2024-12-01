package demo_api.services;

import demo_api.models.Category;
import demo_api.models.dto.CategoryDTO;
import demo_api.models.enums.CategoryType;

import java.util.List;

public interface CategoryService {

    public void createCategory(Category category);
    public Category getCategory(Long id);
    public List<Category> getAllCategories();
    public void deleteCategory(long id);
    public boolean hasCategory(CategoryType categoryType);
}

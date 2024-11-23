package demo_api.services;

import demo_api.models.Category;
import demo_api.models.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {

    public void createCategory(Category category);
    public Category getCategory(Long id);
    public List<Category> getAllCategories();
}

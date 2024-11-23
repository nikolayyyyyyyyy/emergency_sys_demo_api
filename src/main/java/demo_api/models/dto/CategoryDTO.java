package demo_api.models.dto;

import demo_api.models.enums.CategoryType;

public class CategoryDTO {

    private CategoryType categoryType;

    public CategoryDTO(CategoryType categoryType) {
        this.categoryType = categoryType;
    }

    public CategoryDTO() {
    }

    public CategoryType getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(CategoryType categoryType) {
        this.categoryType = categoryType;
    }
}

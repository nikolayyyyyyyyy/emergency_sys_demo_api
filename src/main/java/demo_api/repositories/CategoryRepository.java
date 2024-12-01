package demo_api.repositories;

import demo_api.models.Category;
import demo_api.models.enums.CategoryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    public Category findByCategoryType(CategoryType categoryType);
}

package elte.alkfejlbead.webshop.service;

import elte.alkfejlbead.webshop.entity.Category;
import elte.alkfejlbead.webshop.model.api.request.ListDTO;
import elte.alkfejlbead.webshop.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category addNewCategory(Category category) {
        return categoryRepository.save(category);
    }

    public void deleteCategory(int categoryId) {
        categoryRepository.delete(categoryId);
    }

    public void updateCategory(Category category) {
        Category updatedCategory = categoryRepository.findOne(category.getId());
        updatedCategory.setAboveEighteen(category.isAboveEighteen());
        updatedCategory.setCategoryName(category.getCategoryName());
        categoryRepository.save(updatedCategory);
    }

    public ListDTO<Category> getCategories() {
        ListDTO<Category> categories = new ListDTO<>();
        categories.setItems(categoryRepository.findAll());
        return categories;
    }
}

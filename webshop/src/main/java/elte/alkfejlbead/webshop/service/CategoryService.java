package elte.alkfejlbead.webshop.service;

import elte.alkfejlbead.webshop.entity.Category;
import elte.alkfejlbead.webshop.entity.Game;
import elte.alkfejlbead.webshop.model.api.request.ListDTO;
import elte.alkfejlbead.webshop.repository.CategoryRepository;
import elte.alkfejlbead.webshop.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;
    private GameRepository gameRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository, GameRepository gameRepository) {
        this.categoryRepository = categoryRepository;
        this.gameRepository = gameRepository;
    }

    public Category addNewCategory(Category category) {
        return categoryRepository.save(category);
    }

    public void deleteCategory(int categoryId) {

        List<Game> gamesWithCategory = gameRepository.findAllByCategoryId(categoryId);
        for (Game game : gamesWithCategory) {
            game.getCategories().removeIf(c -> c.getId().equals(categoryId));
            gameRepository.save(game);
        }
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
        categories.setItems(categoryRepository.findAllByOrderByCategoryNameAsc());
        return categories;
    }
}

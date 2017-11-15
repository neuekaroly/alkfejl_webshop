package elte.alkfejlbead.webshop.controller;

import elte.alkfejlbead.webshop.annotation.Role;
import elte.alkfejlbead.webshop.entity.Category;
import elte.alkfejlbead.webshop.entity.User;
import elte.alkfejlbead.webshop.model.api.request.ListDTO;
import elte.alkfejlbead.webshop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/categories")
@CrossOrigin("*")
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Role(User.Role.ADMIN)
    @PostMapping("")
    public Category addCategory(HttpServletRequest request, @RequestBody Category category) {
        return categoryService.addNewCategory(category);
    }

    @Role(User.Role.ADMIN)
    @DeleteMapping("/{categoryId}")
    public void deleteCategory(HttpServletRequest request, @PathVariable int categoryId) {
        categoryService.deleteCategory(categoryId);
    }

    @Role(User.Role.ADMIN)
    @PatchMapping("/update")
    public void updateCategory(HttpServletRequest request, @RequestBody Category category) {
        categoryService.updateCategory(category);
    }

    @Role(User.Role.USER)
    @GetMapping("")
    public ListDTO<Category> getCategories() {
        return categoryService.getCategories();
    }
}

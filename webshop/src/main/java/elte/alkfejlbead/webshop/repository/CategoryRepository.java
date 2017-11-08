package elte.alkfejlbead.webshop.repository;

import elte.alkfejlbead.webshop.entity.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {
        Optional<Category> findByCategoryName(String categoryName);
}

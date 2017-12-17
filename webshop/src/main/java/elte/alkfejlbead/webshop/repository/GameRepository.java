package elte.alkfejlbead.webshop.repository;

import elte.alkfejlbead.webshop.entity.Category;
import elte.alkfejlbead.webshop.model.api.request.FilterDTO;
import elte.alkfejlbead.webshop.model.api.request.ListDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import elte.alkfejlbead.webshop.entity.Game;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GameRepository extends CrudRepository<Game, Integer> {
    @Query("select g from Game g where g.gameName like CONCAT('%',:searchName,'%') order by g.price ASC")
    List<Game> searchByGameName(@Param("searchName") String searchName);
    List<Game> findAllByOrderByPriceAsc();

    @Query("select g from Game g left join fetch g.categories c where g.gameName like CONCAT('%',:searchTag,'%') AND g.price <= :priceTag AND g.platform IN :platforms AND c.id IN :categories order by g.price ASC")
   List<Game> advancedSearch(@Param("searchTag") String searchTag, @Param("priceTag") Integer priceTag, @Param("platforms") List<Game.Platform> platforms, @Param("categories") List<Integer> categories);
}
package elte.alkfejlbead.webshop.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import elte.alkfejlbead.webshop.entity.Game;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GameRepository extends CrudRepository<Game, Integer> {
    @Query("select g from Game g where g.gameName like CONCAT('%',:searchName,'%')")
    Game searchByGameName(@Param("searchName") String searchName);
}
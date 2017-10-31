package elte.alkfejlbead.webshop.repository;

import org.springframework.data.repository.CrudRepository;
import elte.alkfejlbead.webshop.entity.Games;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GamesRepository extends CrudRepository<Games, Long> {
    List<Games> findAllByGameName(String gameName);
    List<Games> findAllByCategory(Games.Categories category);
}
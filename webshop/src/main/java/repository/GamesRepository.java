package repository;

import org.springframework.data.repository.CrudRepository;
import entity.Games;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GamesRepository extends CrudRepository<Games, Long> {
    List<Games> findAllByGameName(String text);
    List<Games> findAllByCategory(Games.Categories category);
    Optional<Games> findByGameName(String gameName);
}
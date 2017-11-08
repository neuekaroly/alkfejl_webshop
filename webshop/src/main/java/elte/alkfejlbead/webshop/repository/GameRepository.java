package elte.alkfejlbead.webshop.repository;

import org.springframework.data.repository.CrudRepository;
import elte.alkfejlbead.webshop.entity.Game;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends CrudRepository<Game, Integer> {

}
package elte.alkfejlbead.webshop.repository;

import elte.alkfejlbead.webshop.entity.Developer;
import elte.alkfejlbead.webshop.entity.Game;
import elte.alkfejlbead.webshop.entity.OrderItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface DeveloperRepository extends CrudRepository<Developer, Integer> {
    Optional<Developer> findByDevelopername(Developer developer);

    @Query("select d from Developer d, IN (d.games) AS g where g.id =:id")
    Optional<Developer> findByGame(@Param("id") Integer id);
}

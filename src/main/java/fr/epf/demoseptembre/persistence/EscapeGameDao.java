package fr.epf.demoseptembre.persistence;

import fr.epf.demoseptembre.models.EscapeGame;
import fr.epf.demoseptembre.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * TODO class details.
 *
 * @author Loïc Ortola on 10/09/2018
 */
@Repository
public interface EscapeGameDao extends CrudRepository<EscapeGame, Integer> {

}
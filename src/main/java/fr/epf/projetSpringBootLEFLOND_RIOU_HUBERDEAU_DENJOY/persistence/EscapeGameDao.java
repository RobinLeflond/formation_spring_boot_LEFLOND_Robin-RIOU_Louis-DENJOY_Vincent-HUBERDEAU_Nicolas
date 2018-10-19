package fr.epf.projetSpringBootLEFLOND_RIOU_HUBERDEAU_DENJOY.persistence;

import fr.epf.projetSpringBootLEFLOND_RIOU_HUBERDEAU_DENJOY.models.EscapeGame;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EscapeGameDao extends CrudRepository<EscapeGame, Integer> {

}

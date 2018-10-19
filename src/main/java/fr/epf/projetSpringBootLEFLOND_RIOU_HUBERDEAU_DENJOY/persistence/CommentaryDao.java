package fr.epf.projetSpringBootLEFLOND_RIOU_HUBERDEAU_DENJOY.persistence;

import fr.epf.projetSpringBootLEFLOND_RIOU_HUBERDEAU_DENJOY.models.Commentary;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentaryDao extends CrudRepository<Commentary, Integer> {


}
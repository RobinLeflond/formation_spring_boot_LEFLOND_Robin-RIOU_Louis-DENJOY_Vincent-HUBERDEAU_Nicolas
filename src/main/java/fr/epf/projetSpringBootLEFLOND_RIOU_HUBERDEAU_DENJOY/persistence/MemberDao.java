package fr.epf.projetSpringBootLEFLOND_RIOU_HUBERDEAU_DENJOY.persistence;

import fr.epf.projetSpringBootLEFLOND_RIOU_HUBERDEAU_DENJOY.models.Member;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberDao extends CrudRepository<Member, Integer> {

}


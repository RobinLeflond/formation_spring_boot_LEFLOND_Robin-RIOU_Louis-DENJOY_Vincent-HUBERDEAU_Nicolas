package fr.epf.projetSpringBootLEFLOND_RIOU_HUBERDEAU_DENJOY;

import fr.epf.projetSpringBootLEFLOND_RIOU_HUBERDEAU_DENJOY.models.EscapeGame;
import fr.epf.projetSpringBootLEFLOND_RIOU_HUBERDEAU_DENJOY.persistence.EscapeGameDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableJpaRepositories
public class ProjetSpringBootApplication {
  
  @Autowired
  private EscapeGameDao escapeGameDao;

  public static void main(String[] args) {
    SpringApplication.run(ProjetSpringBootApplication.class);
  }


  @PostConstruct
  public void init() {

  // Put this only if you're using a new BDD for the first time
    escapeGameDao.deleteAll();
    escapeGameDao.save(new EscapeGame(1,"Mike92", "ONE HOUR Live escape game", "Echappez vous de cet asile avant d'en devenir fou !", null, "horreur", 0, "05/06/2018", "24 rue Emile Lepeu 75011 Paris"));
    escapeGameDao.save(new EscapeGame(2,"Lamiss2433", "Braquage à la française", "Saurez vous menez à bout de cet étrange braquage à la française sans vous faire attraper ?", null, "policier", 0, "07/04/2017", "51 rue du cardinal Lemoine 75005 Paris"));
    escapeGameDao.save(new EscapeGame(3,"Cyremia", "Les Catacombes", "Retrouver le précieux testament oublié parmis les morts dans cette catacombe", null, "horreur", 0, "10/09/2018", "51 rue du cardinal Lemoine 75005 Paris"));
    escapeGameDao.save(new EscapeGame(4,"Annabelle666", "Le Bunker Zombie", "Dans un monde envahi par les zombies, oserez-vous franchir la porte blindée aux risques d'y rester ?", null, "horreur", 0, "22/10/2018", "26 rue Richer 75009 Paris"));
    escapeGameDao.save(new EscapeGame(5,"Houdini78", "DA VINCI", "Retrouvez le fameux trésor de Léonard de Vinci au travers d'énigmes et d'indices", null, "illusions", 0, "28/02/2018", "127 rue Jeanne d'Arc 75013 Paris"));

  }
}
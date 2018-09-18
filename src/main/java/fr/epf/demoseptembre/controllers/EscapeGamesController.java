package fr.epf.demoseptembre.controllers;

import fr.epf.demoseptembre.models.EscapeGame;
import fr.epf.demoseptembre.persistence.EscapeGameDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * TODO class details.
 *
 * @author Loïc Ortola on 10/09/2018
 */
@Controller
public class EscapeGamesController {

    private final EscapeGameDao escapeGameDao;

    public EscapeGamesController(EscapeGameDao escapeGameDao) {
        this.escapeGameDao = escapeGameDao;
    }

    /**
     * Ceci sera mappé sur l'URL '/escapeGames'.
     * C'est le routeur de Spring MVC qui va détecter et appeler directement cette méthode.
     * Il lui fournira un "modèle", auquel on pourra rajouter des attributs.
     * Ce modèle sera ensuite forwardé à une page web (dans resources/templates).
     * Le nom de la template est retourné par la fonction. Ici, elle appelle donc le template "escapeGames".
     *
     * @param model le modèle
     * @return
     */

    @GetMapping("/escapeGame")
    public String getEscapeGame(Model model) {
        model.addAttribute("data", escapeGameDao.findAll());
        return "escapeGames-list";
    }


    @PostMapping("/escapeGame")
    public String addEscapeGame(EscapeGame escapeGame, Model model) {
        escapeGameDao.save(escapeGame);
        return "redirect:/escapeGames";
    }
}
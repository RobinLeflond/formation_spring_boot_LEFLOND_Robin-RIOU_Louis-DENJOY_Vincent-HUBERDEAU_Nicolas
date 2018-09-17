package fr.epf.demoseptembre.controllers;

import fr.epf.demoseptembre.models.Membre;
import fr.epf.demoseptembre.persistence.MembreDao;
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
public class MembresController {

    private final MembreDao membreDao;

    public MembresController(MembreDao membreDao) {
        this.membreDao = membreDao;
    }

    /**
     * Ceci sera mappé sur l'URL '/membres'.
     * C'est le routeur de Spring MVC qui va détecter et appeler directement cette méthode.
     * Il lui fournira un "modèle", auquel on pourra rajouter des attributs.
     * Ce modèle sera ensuite forwardé à une page web (dans resources/templates).
     * Le nom de la template est retourné par la fonction. Ici, elle appelle donc le template "membres".
     *
     * @param model le modèle
     * @return
     */

    @GetMapping("/membre")
    public String getMembre(Model model) {
        model.addAttribute("data", membreDao.findAll());
        return "membres-list";
    }


    @PostMapping("/membre")
    public String addMembre(Membre membre, Model model) {
        membreDao.save(membre);
        return "redirect:/membres";
    }
}
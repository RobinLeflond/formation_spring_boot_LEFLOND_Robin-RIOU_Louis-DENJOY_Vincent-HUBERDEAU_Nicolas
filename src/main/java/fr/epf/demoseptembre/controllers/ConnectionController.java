package fr.epf.demoseptembre.controllers;

import fr.epf.demoseptembre.models.Connection;
import fr.epf.demoseptembre.persistence.ConnectionDao;
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
public class ConnectionController {

    private final ConnectionDao connectionDao;

    public ConnectionController(ConnectionDao connectionDao) {
        this.connectionDao = connectionDao;
    }

    /**
     * Ceci sera mappé sur l'URL '/commentaires'.
     * C'est le routeur de Spring MVC qui va détecter et appeler directement cette méthode.
     * Il lui fournira un "modèle", auquel on pourra rajouter des attributs.
     * Ce modèle sera ensuite forwardé à une page web (dans resources/templates).
     * Le nom de la template est retourné par la fonction. Ici, elle appelle donc le template "commentaires".
     *
     * @param model le modèle
     * @return
     */

    @GetMapping("/connection")
    public String getConnection(Model model) {
        return "connection";
    }

    @PostMapping("/connection")
    public String connection(Connection connection, Model model) {
        connectionDao.save(connection);
        return "redirect:/connection";
    }
}
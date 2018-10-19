package fr.epf.projetSpringBootLEFLOND_RIOU_HUBERDEAU_DENJOY.controllers;

import fr.epf.projetSpringBootLEFLOND_RIOU_HUBERDEAU_DENJOY.models.Commentary;
import fr.epf.projetSpringBootLEFLOND_RIOU_HUBERDEAU_DENJOY.models.EscapeGame;
import fr.epf.projetSpringBootLEFLOND_RIOU_HUBERDEAU_DENJOY.models.Member;
import fr.epf.projetSpringBootLEFLOND_RIOU_HUBERDEAU_DENJOY.persistence.CommentaryDao;
import fr.epf.projetSpringBootLEFLOND_RIOU_HUBERDEAU_DENJOY.persistence.EscapeGameDao;
import fr.epf.projetSpringBootLEFLOND_RIOU_HUBERDEAU_DENJOY.persistence.MemberDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class Controllers {

    // global variables
    private final CommentaryDao commentaryDao;
    private final EscapeGameDao escapeGameDao;
    private final MemberDao memberDao;
    private int id;
    private int id_user = 0;
    private EscapeGame newEscapeGame = new EscapeGame(4,"Annabelle666", "Le Bunker Zombie", "Dans un monde envahi par les zombies, oserez-vous franchir la porte blindée aux risques d'y rester ?", null, "horreur", 0, "22/10/2018", "26 rue Richer 75009 Paris");


    public Controllers(CommentaryDao commentaryDao, EscapeGameDao escapeGameDao, MemberDao memberDao) {
        this.commentaryDao = commentaryDao;
        this.escapeGameDao = escapeGameDao;
        this.memberDao = memberDao;
    }


    // Redirect into home
    @GetMapping("/")
    public String goHome(Model model) {
        model.addAttribute("data", this.escapeGameDao.findAll());
        model.addAttribute("newEscapeGame", newEscapeGame);
        if (this.id_user == 0) {
            return "index.html";
        } else {
            model.addAttribute("user", this.memberDao.findById(this.id_user).get().getPseudo());
            return "connected_home.html";
        }
    }

    @GetMapping("/deconnection")
    public String deconnection(Model model) {
        model.addAttribute("data", this.escapeGameDao.findAll());
        model.addAttribute("newEscapeGame", newEscapeGame);
        this.id_user = 0;
        return "redirect:/";
    }

    @GetMapping("/inscription")
    public String inscription(Model model) {
        model.addAttribute("member", new Member());
        model.addAttribute("data", this.memberDao.findAll());
        return "inscription";
    }

    // create a new member
    @PostMapping("/inscription")
    public String addMember(Member member, Model model) {
        this.memberDao.save(member);
        this.id_user = member.getId();
        return "redirect:/";
    }

    @GetMapping("/connection")
    public String connection(Model model) {
        model.addAttribute("member", new Member());
        model.addAttribute("data", memberDao.findAll());
        return "connection";
    }

    @PostMapping("/connection")
    public String session(Member member, Model model) {
        for (Member memberN : this.memberDao.findAll()) {
            if ((memberN.getPseudo() != null) && (memberN.getPassword() != null)) {
                System.out.println(memberN.getPseudo());
                if (member.getPseudo().equals(memberN.getPseudo()) && member.getPassword().equals(memberN.getPassword())) {
                    this.id_user = memberN.getId();
                    return "redirect:/";
                }
            }
        }
        return "redirect:/inscription";
    }

    // display the list of commentaries
    @GetMapping("/commentariesList")
    public String getCommentaries(Model model) {
        model.addAttribute("data", this.commentaryDao.findAll());
        return "commentaries_list";
    }

    // display an escape game
    @GetMapping("/escapeGame/{id}")
    public String getEscapeGame(Model model, @PathVariable int id) {
        this.id = id;
        model.addAttribute("escapeGame", this.escapeGameDao.findById(this.id).get());
        return "escapeGame_description";
    }


    @GetMapping("/commentary/{id}")
    public String getCommentary(Model model, @PathVariable int id) {
        this.id = id;
        model.addAttribute("user", this.memberDao.findById(this.id_user).get().getPseudo());
        model.addAttribute("commentary", new Commentary());
        model.addAttribute("nom", this.escapeGameDao.findById(this.id).get().getName());
        model.addAttribute("data", this.commentaryDao.findAll());
        return "add_commentary";
    }

    //post a commentary
    @PostMapping("/commentary/{id}")
    public String addCommentary(Commentary commentary, Model model, @PathVariable int id) {
        commentary.setEscape_game(this.escapeGameDao.findById(id).get().getName());
        commentary.setAuthor(this.memberDao.findById(this.id_user).get().getPseudo());

        // calculation of the escape game note
        Double note = 0.0;
        this.escapeGameDao.findById(id).get().setNb_Notes(this.escapeGameDao.findById(id).get().getNb_Notes() + 1);
        if (this.escapeGameDao.findById(id).get().getNote() == null) {
            note = commentary.getNote();
        } else {
            System.out.println(this.escapeGameDao.findById(id).get().getNb_Notes());
            note = (commentary.getNote() + this.escapeGameDao.findById(id).get().getNote()) / this.escapeGameDao.findById(id).get().getNb_Notes();
        }
        System.out.println(this.escapeGameDao.findById(id).get().getNb_Notes());
        this.escapeGameDao.findById(id).get().setNote(note);

        this.commentaryDao.save(commentary);
        return "redirect:/";
    }

    @GetMapping("/addEscapeGame")
    public String createEscapeGame(Model model) {
        model.addAttribute("user", this.memberDao.findById(this.id_user).get().getPseudo());
        model.addAttribute("escapeGame", new EscapeGame());
        return "add_EscapeGame";
    }


    // create a new escape Game
    @PostMapping("/addEscapeGame")
    public String addEscapeGameSubmit(EscapeGame escapeGame) {
        escapeGame.setCreator(this.memberDao.findById(this.id_user).get().getPseudo());
        this.escapeGameDao.save(escapeGame);
        this.newEscapeGame = escapeGame;
        return "redirect:/";
    }

}
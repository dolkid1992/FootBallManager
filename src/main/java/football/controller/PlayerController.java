package football.controller;

import football.model.Player;
import football.model.TeamFootball;
import football.service.PlayerService;
import football.service.TeamFootballService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @Autowired
    private TeamFootballService teamFootballService;

    @ModelAttribute("list")
    public Iterable<TeamFootball> teamFootballs() {
        return teamFootballService.findAll();
    }



    @GetMapping("/create-player")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/player/create");
        modelAndView.addObject("player", new Player());
        return modelAndView;
    }

    @PostMapping("/create-player")
    public ModelAndView saveBlogger(@ModelAttribute("player") Player player) {
        playerService.save(player);

        ModelAndView modelAndView = new ModelAndView("/player/create");
        modelAndView.addObject("player", new Player());
        modelAndView.addObject("message", "New Player created successfully");
        return modelAndView;
    }

    @GetMapping("/listPlayer")
    public ModelAndView listPlayer() {
        Iterable<Player> list = playerService.findAll();
        ModelAndView modelAndView = new ModelAndView("/player/list");
        modelAndView.addObject("list", list);
        return modelAndView;
    }

    @GetMapping("/edit-player/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Player player = playerService.findById(id);
            ModelAndView modelAndView = new ModelAndView("/player/edit");
            modelAndView.addObject("player", player);
            return modelAndView;
    }

    @PostMapping("/edit-player/{id}")
    public ModelAndView updatePlayer(@ModelAttribute("player") Player player) {
        playerService.save(player);
        ModelAndView modelAndView = new ModelAndView("/player/edit");
        modelAndView.addObject("player", player);
        modelAndView.addObject("message", "Player upload successfuly");
        return modelAndView;
    }

    @GetMapping("/delete-player/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Player player = playerService.findById(id);
            ModelAndView modelAndView = new ModelAndView("/player/delete");
            modelAndView.addObject("player", player);
            return modelAndView;
    }

    @PostMapping("/delete-player")
    public String deletePlayer(@ModelAttribute("player") Player player) {
        playerService.remove(player.getId());
        return "redirect:listPlayer";
    }
}

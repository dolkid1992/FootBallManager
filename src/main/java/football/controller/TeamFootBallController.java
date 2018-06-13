package football.controller;

import football.model.TeamFootball;
import football.service.TeamFootballService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TeamFootBallController {

    @Autowired
    private TeamFootballService teamFootballService;

    @GetMapping("/create-team")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/teamFootball/create");
        modelAndView.addObject("team", new TeamFootball());
        return modelAndView;
    }

    @PostMapping("/create-team")
    public ModelAndView saveBlogger(@ModelAttribute("team") TeamFootball teamFootball) {
        teamFootballService.save(teamFootball);

        ModelAndView modelAndView = new ModelAndView("/teamFootball/create");
        modelAndView.addObject("team", new TeamFootball());
        modelAndView.addObject("message", "New TeamFootball created successfully");
        return modelAndView;
    }

    @GetMapping("/list")
    public ModelAndView listTeam() {
        Iterable<TeamFootball> list = teamFootballService.findAll();
        ModelAndView modelAndView = new ModelAndView("/teamFootball/list");
        modelAndView.addObject("list", list);
        return modelAndView;
    }

    @GetMapping("/edit-team/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        TeamFootball teamFootball = teamFootballService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/teamFootball/edit");
        modelAndView.addObject("team", teamFootball);
        return modelAndView;

    }

    @PostMapping("/edit-team/{id}")
    public ModelAndView updateteam(@ModelAttribute("team") TeamFootball teamFootball) {
        teamFootballService.save(teamFootball);
        ModelAndView modelAndView = new ModelAndView("/teamFootball/edit");
        modelAndView.addObject("team", teamFootball);
        modelAndView.addObject("message", "Blogger upload successfuly");
        return modelAndView;
    }

    @GetMapping("/delete-team/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        TeamFootball teamFootball = teamFootballService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/teamFootball/delete");
        modelAndView.addObject("team", teamFootball);
        return modelAndView;
            }


    @PostMapping("/delete-team")
    public String deleteBlogger(@ModelAttribute("team") TeamFootball teamFootball) {
        teamFootballService.remove(teamFootball.getId());
        return "redirect:list";
    }
}

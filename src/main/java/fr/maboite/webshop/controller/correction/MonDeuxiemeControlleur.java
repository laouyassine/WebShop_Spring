package fr.maboite.webshop.controller.correction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import fr.maboite.webshop.model.Planete;

@Controller
public class MonDeuxiemeControlleur {

    private final PlaneteService planeteService;

    @Autowired
    public MonDeuxiemeControlleur(PlaneteService planeteService) {
        this.planeteService = planeteService;
    }

    @GetMapping("/planetes")
    public String listPlanets(Model model) {
        model.addAttribute("planetes", planeteService.getAll());
        return "planete";
    }

    @GetMapping("/detail/{id}")
    public String planetDetail(@PathVariable("id") int id, Model model) {
        Planete planete = planeteService.getById(id);
        model.addAttribute("planete", planete);
        return "planetedetail"; 
    }
}

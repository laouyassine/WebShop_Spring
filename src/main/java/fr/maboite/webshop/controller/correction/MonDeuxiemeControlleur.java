package fr.maboite.webshop.controller.correction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import fr.maboite.webshop.model.Planete;
import jakarta.validation.Valid;

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
        return "planetes"; 
    }

    @GetMapping("/detail/{id}")
    public String planetDetail(@PathVariable("id") int id, Model model) {
        Planete planete = planeteService.getById(id);
        model.addAttribute("planete", planete);
        return "planetDetail";
    }

    @PostMapping("/planete")
    public ModelAndView sauvegardePlanete(@Valid @ModelAttribute("planete") Planete planete,
            BindingResult bindingResult) {

        ModelAndView mav = new ModelAndView();

        if (bindingResult.hasErrors()) {
            mav.setViewName("planetDetail");
            mav.addObject("planete", planete);
            System.out.println("Erreurs de validation détectées.");
        } else {
            planeteService.save(planete);
            mav.setViewName("redirect:/detail/" + planete.getId());
        }
        System.out.println("Sauvegarde bonne.");

        return mav;
    }
}

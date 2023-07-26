package fr.maboite.webshop.mvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.maboite.webshop.model.Example;
import fr.maboite.webshop.service.ExampleService;

/**
 * Annotée par @Controller, cette 
 * classe va être considérée par Spring
 * MVC pour traiter des requêtes.
 */
@Controller
public class ExampleControleur {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ExampleControleur.class);
	
	@Autowired
	private ExampleService exampleService;

	
	/**
	 * Affiche la page des examples. Ajoute examples dans le modele.
	 * 
	 * @return
	 */
	@RequestMapping("/examples")
	public ModelAndView afficheExamples() {
		LOGGER.info("Affichage de tous les examples");
		Iterable<Example> examples = exampleService.findAll();
    	
    	
    	ModelAndView mav = new ModelAndView();
		mav.setViewName("example/examples");
		mav.addObject("examples", examples);
        return mav;
    }
    
	@RequestMapping("/example-detail")
	public ModelAndView afficheDetailExample(@RequestParam("id") Long id) {
		LOGGER.info("Affichage du example avec l'id : {}", id);
		Example example = exampleService.findById(id);
    	
    	ModelAndView mav = new ModelAndView();
		mav.setViewName("example/example-detail");
		mav.addObject("example", example);
        return mav;
    }
    
	@PostMapping("/example-sauvegarde")
    public ModelAndView processSubmit( 
			@Validated @ModelAttribute("example") Example example,
			BindingResult result) {
    	if(result.hasErrors()) {
			// return new ModelAndView("example", "example", example);
        	ModelAndView mav = new ModelAndView();
			mav.setViewName("example/example-detail");
			mav.addObject("example", example);
            return mav;
    	}
    	
		Example exampleSauvegarde = exampleService.save(example);
    	
    	ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/example-detail?id=" + exampleSauvegarde.getId());
        return mav;
    }
    
}
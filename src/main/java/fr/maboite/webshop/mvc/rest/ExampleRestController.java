package fr.maboite.webshop.mvc.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import fr.maboite.webshop.model.Example;
import fr.maboite.webshop.mvc.rest.dto.ExampleRestDto;
import fr.maboite.webshop.service.ExampleService;

/**
 * Contrôleur REST pour le example
 */
@RestController
public class ExampleRestController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ExampleRestController.class);

	@Autowired
	private ExampleService exampleService;

	/**
	 * Récupère le example avec l'id passé en paramètre
	 * 
	 * @param exampleId
	 * @return
	 */
	@GetMapping("/examples/{exampleId}")
	public ExampleRestDto getById(@PathVariable("exampleId") Long exampleId) {
		Example example = exampleService.findById(exampleId);
		if (example == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucun example trouvé avec l'id : "
					+ exampleId);
		}
		return new ExampleRestDto(example);
	}

	/**
	 * Supprime le example avec l'identifiant passé en paramètre
	 * 
	 * @param id
	 */
	@DeleteMapping("/examples/{id}")
	public void deleteById(@PathVariable("id") Long id) {
		Example example = exampleService.findById(id);
		if (example == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucun example trouvé avec l'id : "
					+ id);
		}
		exampleService.delete(id);
	}

	/**
	 * Sauvegarde un example passé dans le corps de la réponse. Renvoie le example
	 * créé dans le corps de la réponse.
	 * 
	 * @param exampleRestDto
	 * @param bindingResult
	 * @return
	 */
	@PostMapping("/examples")
	public ExampleRestDto save(@Validated @RequestBody ExampleRestDto exampleRestDto,
			BindingResult bindingResult) {
		LOGGER.info("Appel de la méthode save pour le example : {}", exampleRestDto);
		// Validation du ExampleRestDto
		if (bindingResult.hasErrors()) {
			StringBuilder sb = new StringBuilder();
			for (ObjectError objectError : bindingResult.getAllErrors()) {
				sb.append(objectError.getObjectName()).append("-").append(objectError.getDefaultMessage());
			}
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, sb.toString());
		}

		Example example = exampleRestDto.toExample();

		// On sauvegarde l'entité
		example = exampleService.save(example);

		// La sauvegarde s'est bien déroulée, le example est retransformé en
		// DTO pour être renvoyé dans le corps de la réponse HTTP
		return new ExampleRestDto(example);
	}

}
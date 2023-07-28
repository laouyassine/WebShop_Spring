package fr.maboite.webshop.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.maboite.webshop.correction.service.MonDeuxiemeService;
import fr.maboite.webshop.correction.service.MonPremierService;

public class SpringSimpleApplication {

	public static void main(String[] args) {

		// Démarre le contexte Spring
		// et scanne le package "fr.maboite.webshop.correction"
		try (AnnotationConfigApplicationContext appContext 
				= new AnnotationConfigApplicationContext("fr.maboite.webshop.correction")) {
			System.out.println("Contexte Spring démarré");

			// Récupération du bean instancié par Spring (et potentiellement rattaché à
			// d'autres beans Spring)
			MonPremierService monPremierBeanSpring = appContext.getBean(MonPremierService.class);

			// Opérations sur les objets ...
			monPremierBeanSpring.coucou();
			monPremierBeanSpring.getMonPremierDao().coucou();

			MonDeuxiemeService monDeuxiemeBeanSpring = appContext.getBean(MonDeuxiemeService.class);
			monDeuxiemeBeanSpring.coucou();
		}

	}

}
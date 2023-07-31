package fr.maboite.webshop.correction.spring.application;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.maboite.webshop.correction.service.simple.MonDeuxiemeService;
import fr.maboite.webshop.correction.service.simple.MonPremierService;

/**
 * Application 'simple' de spring : scanne un package et force Spring à mettre
 * dans son contexte une instance de toute les classes annotées avec @Component
 * de ce package (et de ses enfants).
 */
public class SpringSimpleApplication {

	public static void main(String[] args) {

		// Démarrage du contexte Spring
		// et scan le package "fr.maboite.webshop.correction"
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
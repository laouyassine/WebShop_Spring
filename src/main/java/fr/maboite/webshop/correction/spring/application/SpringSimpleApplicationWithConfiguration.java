package fr.maboite.webshop.correction.spring.application;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.maboite.webshop.correction.service.simple.MonDeuxiemeService;
import fr.maboite.webshop.correction.service.simple.MonPremierService;
import fr.maboite.webshop.correction.spring.configuration.SpringSimpleConfiguration;

/**
 * Application 'simple' de spring : lit une classe de configuration qui va
 * indiquer à Spring comment démarrer son contexte (et le remplir avec des
 * beans).
 */
public class SpringSimpleApplicationWithConfiguration {

	public static void main(String[] args) {

		// Démarrage du contexte Spring
		// lecture de SpringSimpleConfiguration
		try (AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(
				SpringSimpleConfiguration.class)) {
			System.out.println("J'ai démarré le contexte");

			// Récupération d'un bean dans le contexte via sa classe et
			// appel de la méthode coucou
			appContext.getBean(MonDeuxiemeService.class).coucou();

			// Tests sur un autre bean de Spring
			MonPremierService monPremierServiceVariable1 = appContext.getBean(MonPremierService.class);
			monPremierServiceVariable1.setNom("nom 1");
			monPremierServiceVariable1.coucou();
			monPremierServiceVariable1.getMonPremierDao().coucou();
			System.out.println("La valeur venant de la configuration vaut : "
					+ monPremierServiceVariable1.getProprieteDeConfiguration());


			// Tests sur un autre bean de Spring
			// Celui-ci peut être le même que le précédent,
			// Si le Scope Spring est Singleton, ou un objet différent si le scope de
			// Spring est prototype
			MonPremierService monPremierServiceVariable2 = appContext.getBean(MonPremierService.class);
			System.out.println("Le nom de monPremierServiceVariable2 vaut : "
					+ monPremierServiceVariable2.getNom());
			System.out.println(
					"Est-ce qu'il n'y a qu'une seule instance de la classe "
							+ " MonPremierService dans le contexte Sprint ? "
							+ (monPremierServiceVariable1 == monPremierServiceVariable2));

		}
	}

}

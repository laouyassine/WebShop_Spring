package fr.maboite.webshop.spring;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.maboite.webshop.correction.service.ExampleService;
import fr.maboite.webshop.model.Example;
import fr.maboite.webshop.spring.real.configuration.SpringConfiguration;

public class SpringJpaApplication {

	public static void main(String[] args) {
		//On démarre le contexte Spring
		//avec la configuration qui se trouve dans SpringConfiguration.class
		try (AnnotationConfigApplicationContext appContext 
				= new AnnotationConfigApplicationContext(
				SpringConfiguration.class)) {
			ExampleService exampleServiceBean = (ExampleService) appContext.getBean("exampleService");

			Example nouvelExample = new Example();
			nouvelExample.setNom("Nouveau nom");
			nouvelExample.setTaille(10f);
			exampleServiceBean.save(nouvelExample);
			
			Iterable<Example> allExamples = exampleServiceBean.getAll();
			for (Example example : allExamples) {
				System.out.println("En base, j'ai un example avec le nom : " + example.getNom());
			}

			Example example1 = exampleServiceBean.getById(1l);
			System.out.println("L'example 1 a le nom : " + example1.getNom());

			Iterable<Example> examplesNouveauNom = exampleServiceBean.getByNom("OUveau NOM");
			for (Example example : examplesNouveauNom) {
				System.out.println("Cet exemple devrait avoir comme nom : Nouveau nom  : "
						+ example.getNom() + " son id vaut : " + example.getId());
			}

			System.out.println("Appel méthode toto");
			List<Example> toto = exampleServiceBean.toto("Nouveau nom");
			for (Example example : toto) {
				System.out.println("Cet exemple a comme nom  : "
						+ example.getNom() + " son id vaut : " + example.getId()
						+ " sa taille vaut : " + example.getTaille());
			}

			System.out.println("Association d'un Example à sa catégorie");
			exampleServiceBean.coucou();

			System.out.println("Récupération des Examples par nom de catégorie");
			List<Example> examplesByCategory = exampleServiceBean.findByCategory("MATERIEL");
			for (Example example : examplesByCategory) {
				System.out.println("Cet exemple a comme nom  : "
						+ example.getNom() + " son id vaut : " + example.getId()
						+ " sa taille vaut : " + example.getTaille()
						+ " sa catégorie vaut : " + example.getCategory().getNom());
			}

		}
	}

}

package fr.maboite.webshop.spring;

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
			ExampleService exampleServiceBean = appContext.getBean(ExampleService.class);

			Example nouvelExample = new Example();
			nouvelExample.setNom("Nouveau nom");
			nouvelExample.setTaille(4f);
			exampleServiceBean.save(nouvelExample);
			
			Iterable<Example> allExamples = exampleServiceBean.getAll();
			for (Example example : allExamples) {
				System.out.println("En base, j'ai un example avec le nom : " + example.getNom());
			}

			Example example1 = exampleServiceBean.getById(1l);
			System.out.println("L'example 1 a le nom : " + example1.getNom());

		}
	}

}

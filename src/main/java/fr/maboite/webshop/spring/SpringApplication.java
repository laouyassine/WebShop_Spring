package fr.maboite.webshop.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.maboite.webshop.service.ExampleService;
import fr.maboite.webshop.spring.real.configuration.SpringConfiguration;

public class SpringApplication {

	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext appContext 
				= new AnnotationConfigApplicationContext(SpringConfiguration.class)) {
			ExampleService exampleService 
				= appContext.getBean("exampleService", ExampleService.class);
			exampleService.findByNom("toto");
		}
		
	}

}
package fr.maboite.webshop.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.maboite.webshop.spring.simple.configuration.SpringSimpleConfiguration;


public class SpringSimpleApplication {

	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext appContext 
				= new AnnotationConfigApplicationContext(SpringSimpleConfiguration.class)) {
		}
	}

}
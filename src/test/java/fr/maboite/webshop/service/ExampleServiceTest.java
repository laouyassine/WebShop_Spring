package fr.maboite.webshop.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import fr.maboite.webshop.spring.real.configuration.SpringConfiguration;

@SpringJUnitConfig(SpringConfiguration.class)
public class ExampleServiceTest {
	
	@Autowired
	private ExampleService exampleService;

	@Test
	public void testFindByNom() {
		exampleService.findByNom("test");
	}

}

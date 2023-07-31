package fr.maboite.webshop.correction.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import fr.maboite.webshop.correction.service.simple.MonPremierService;
import fr.maboite.webshop.correction.spring.configuration.SpringSimpleConfiguration;

@SpringJUnitConfig(SpringSimpleConfiguration.class)
public class MonPremierServiceTest {

	@Autowired
	private MonPremierService monPremierService;

	@Test
	public void testSum() {
		int resultat = monPremierService.sum(3, 4);
		Assertions.assertEquals(7, resultat);
	}

}

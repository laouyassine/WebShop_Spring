package fr.maboite.webshop.correction.tp.plage.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import fr.maboite.webshop.correction.tp.plage.configuration.SpringPlageConfiguration;
import fr.maboite.webshop.correction.tp.plage.model.Plage;

@SpringJUnitConfig(SpringPlageConfiguration.class)
public class PlageServiceTest {

	@Autowired
	private PlageService plageService;

	@Test
	public void testSaveWithoutId() {
		Plage plage = plageService.save(new Plage());
		Assertions.assertNotNull(plage);
		Assertions.assertNotNull(plage.getId());
	}

	@Test
	public void testSaveWithId() {
		Plage plage = new Plage();
		plage = plageService.save(plage);
		Assertions.assertNotNull(plage);
		Assertions.assertNotNull(plage.getId());
	}

	@Test
	public void testGet() {
		Plage plage = plageService.get(1);
		Assertions.assertNotNull(plage);
		Assertions.assertEquals(1, plage.getId());
	}

}

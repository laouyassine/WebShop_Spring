package fr.maboite.webshop.correction.tp.plage.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import fr.maboite.webshop.correction.tp.plage.configuration.SpringPlageConfiguration;
import fr.maboite.webshop.correction.tp.plage.model.Hotel;

@SpringJUnitConfig(SpringPlageConfiguration.class)
public class HotelServiceTest {

	@Autowired
	private HotelService hotelService;

	@Test
	public void testSaveWithoutId() {
		Hotel hotel = hotelService.save(new Hotel());
		Assertions.assertNotNull(hotel);
		Assertions.assertNotNull(hotel.getId());
	}

	@Test
	public void testSaveWithId() {
		Hotel hotel = new Hotel();
		hotel = hotelService.save(hotel);
		Assertions.assertNotNull(hotel);
		Assertions.assertNotNull(hotel.getId());
	}

	@Test
	public void testGet() {
		Hotel hotel = hotelService.get(1);
		Assertions.assertNotNull(hotel);
		Assertions.assertEquals(1, hotel.getId());
	}

}

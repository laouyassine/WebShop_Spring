package fr.maboite.webshop.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import fr.maboite.webshop.model.Hotel;
import fr.maboite.webshop.spring.real.configuration.SpringConfiguration;

@SpringJUnitConfig(SpringConfiguration.class)
public class HotelServiceTest {

    @Autowired
    private HotelService hotelService;

    public void testGetHotel() {
        Integer hotelId = 1;
        Hotel hotel = hotelService.get(hotelId);

        Assertions.assertEquals(hotelId, hotel.getId());

    }

    @Test
    public void testSaveHotel() {
        Hotel hotel = new Hotel();
        hotel.setNom("Nouvel Hôtel");
        hotel.setVille("Nouvelle Ville");
        Hotel savedHotel = hotelService.save(hotel);

        Assertions.assertEquals("Nouvel Hôtel", savedHotel.getNom());
        Assertions.assertEquals("Nouvelle Ville", savedHotel.getVille());

        
    }
}
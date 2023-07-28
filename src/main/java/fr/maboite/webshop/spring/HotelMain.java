package fr.maboite.webshop.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.maboite.webshop.model.Hotel;
import fr.maboite.webshop.service.HotelService;
import fr.maboite.webshop.spring.simple.configuration.SpringSimpleConfiguration;

public class HotelMain {

    public static void main(String[] args) {

        // Démarre le contexte Spring
        try (AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(
                SpringSimpleConfiguration.class)) {
            System.out.println("Contexte Spring démarré");

            // Récupération du bean instancié par Spring
            HotelService hotelService = appContext.getBean(HotelService.class);

            // Opérations sur les objets ...
            Hotel hotel = new Hotel();
            hotel.setNom("Nouvel Hôtel");
            hotel.setVille("Nouvelle Ville");
            
            Hotel savedHotel = hotelService.save(hotel);
            System.out.println("Hôtel sauvegardé : " + savedHotel);

            Integer hotelId = savedHotel.getId();
            Hotel retrievedHotel = hotelService.get(hotelId);
            System.out.println("Hôtel récupéré : " + retrievedHotel);
        }

    }

}

package fr.maboite.webshop.service;

import org.springframework.stereotype.Component;

import fr.maboite.webshop.model.Hotel;

@Component
public class HotelDao {

    public Hotel get(Integer id) {
        System.out.println("get HotelDao numéro: " + id);

        Hotel hotel = new Hotel();
        hotel.setId(id);
        hotel.setNom("Hôtel Bidon");
        hotel.setVille("Ville bidon");
        return hotel;
    }

    public Hotel save(Hotel hotel) {
        System.out.println("save HotelDao numéro: " + hotel);
        return hotel;
    }
}

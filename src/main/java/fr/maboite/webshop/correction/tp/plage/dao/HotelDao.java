package fr.maboite.webshop.correction.tp.plage.dao;

import org.springframework.stereotype.Service;

import fr.maboite.webshop.correction.tp.plage.model.Hotel;

@Service
public class HotelDao {

	public Hotel save(Hotel hotel) {
		System.out.println("Sauvegarde d'un hôtel dans le DAO");
		if (hotel.getId() == null) {
			hotel.setId(1);
		}
		return hotel;
	}

	public Hotel get(Integer id) {
		System.out.println("Récupération d'un hôtel dans le DAO");
		Hotel hotel = new Hotel();
		hotel.setId(1);
		hotel.setNom("De la plage");
		hotel.setVille("Palavas");
		return hotel;
	}

}

package fr.maboite.webshop.correction.tp.plage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.maboite.webshop.correction.tp.plage.dao.HotelDao;
import fr.maboite.webshop.correction.tp.plage.model.Hotel;

@Service
public class HotelService {

	private static final String HOTEL_PLEIN_PREFIXE = "super";

	@Autowired
	private HotelDao hotelDao;

	public Hotel save(Hotel hotel) {
		System.out.println("Sauvegarde d'un hôtel dans le service");
		return this.hotelDao.save(hotel);
	}

	public Hotel get(Integer id) {
		System.out.println("Récupération d'un hôtel dans le service");
		return this.hotelDao.get(id);
	}

	public boolean isPlein(String hotel) {
		return hotel.startsWith(HOTEL_PLEIN_PREFIXE);
	}

}

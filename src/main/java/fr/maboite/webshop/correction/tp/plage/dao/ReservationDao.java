package fr.maboite.webshop.correction.tp.plage.dao;

import org.springframework.stereotype.Service;

import fr.maboite.webshop.correction.tp.plage.model.Reservation;

@Service
public class ReservationDao {

	public Reservation save(Reservation reservation) {
		System.out.println("Sauvegarde d'une reservation dans le DAO");
		if (reservation.getId() == null) {
			reservation.setId(1);
		}
		return reservation;
	}

	public Reservation get(Integer id) {
		System.out.println("Récupération d'une reservation dans le DAO");
		Reservation reservation = new Reservation();
		reservation.setId(1);
		reservation.setNom("beau soleil");
		return reservation;
	}

}

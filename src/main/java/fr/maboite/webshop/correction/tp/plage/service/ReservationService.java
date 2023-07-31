package fr.maboite.webshop.correction.tp.plage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.maboite.webshop.correction.tp.plage.dao.ReservationDao;
import fr.maboite.webshop.correction.tp.plage.model.DemandeReservation;
import fr.maboite.webshop.correction.tp.plage.model.Reservation;

@Service
public class ReservationService {

	@Autowired
	private HotelService hotelService;

	@Autowired
	private PlageService plageService;

	@Autowired
	private ReservationDao reservationDao;

	public Reservation save(Reservation reservation) {
		System.out.println("Sauvegarde d'une reservation dans le service");
		return this.reservationDao.save(reservation);
	}

	public Reservation get(Integer id) {
		System.out.println("Récupération d'une reservation dans le service");
		return this.reservationDao.get(id);

	}

	public Reservation enregistreDemande(DemandeReservation demandeReservation) {

		if (hotelService.isPlein(demandeReservation.getHotel())) {
			return null;
		}

		if (demandeReservation.getPlage() != null
				&& !plageService.isPlage(demandeReservation.getPlage())) {
			return null;
		}

		Reservation reservation = new Reservation();
		reservation.setDebut(demandeReservation.getDebut());
		reservation.setFin(demandeReservation.getFin());
		reservation.setNom(demandeReservation.getNom());
		return reservationDao.save(reservation);
	}

}

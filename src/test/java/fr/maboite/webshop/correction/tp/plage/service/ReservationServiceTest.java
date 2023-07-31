package fr.maboite.webshop.correction.tp.plage.service;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import fr.maboite.webshop.correction.tp.plage.configuration.SpringPlageConfiguration;
import fr.maboite.webshop.correction.tp.plage.model.DemandeReservation;
import fr.maboite.webshop.correction.tp.plage.model.Reservation;


@SpringJUnitConfig(SpringPlageConfiguration.class)
public class ReservationServiceTest {

	@Autowired
	private ReservationService reservationService;

	@Test
	public void testSaveWithoutId() {
		Reservation reservation = reservationService.save(new Reservation());
		Assertions.assertNotNull(reservation);
		Assertions.assertNotNull(reservation.getId());
	}

	@Test
	public void testSaveWithId() {
		Reservation reservation = new Reservation();
		reservation = reservationService.save(reservation);
		Assertions.assertNotNull(reservation);
		Assertions.assertNotNull(reservation.getId());
	}

	@Test
	public void testGet() {
		Reservation reservation = reservationService.get(1);
		Assertions.assertNotNull(reservation);
		Assertions.assertEquals(1, reservation.getId());
	}

	@Test
	public void testEnregistreDemandeReservationOk() {
		DemandeReservation demandeReservation = new DemandeReservation();
		demandeReservation.setNom("Dupont");
		demandeReservation.setDebut(LocalDate.of(2020, 1, 3));
		demandeReservation.setFin(LocalDate.of(2020, 1, 5));
		demandeReservation.setHotel("A la booonne aubeerge!");
		demandeReservation.setPlage("Super plage");

		Reservation reservation = reservationService.enregistreDemande(demandeReservation);
		Assertions.assertNotNull(reservation);
		Assertions.assertEquals(1, reservation.getId());
	}

	@Test
	public void testEnregistreDemandeReservationHotelPlein() {
		DemandeReservation demandeReservation = new DemandeReservation();
		demandeReservation.setNom("Dupont");
		demandeReservation.setDebut(LocalDate.of(2020, 1, 3));
		demandeReservation.setFin(LocalDate.of(2020, 1, 5));
		demandeReservation.setHotel("super hôtel");
		demandeReservation.setPlage("Super plage");

		Reservation reservation = reservationService.enregistreDemande(demandeReservation);
		Assertions.assertNull(reservation);
	}

	@Test
	public void testEnregistreDemandeReservationSansPlage() {
		DemandeReservation demandeReservation = new DemandeReservation();
		demandeReservation.setNom("Dupont");
		demandeReservation.setDebut(LocalDate.of(2020, 1, 3));
		demandeReservation.setFin(LocalDate.of(2020, 1, 5));
		demandeReservation.setHotel("Au lion dort");
		demandeReservation.setPlage("raffinerie");

		Reservation reservation = reservationService.enregistreDemande(demandeReservation);
		Assertions.assertNull(reservation);
	}

}

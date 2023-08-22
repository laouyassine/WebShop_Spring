package fr.maboite.webshop.correction.service.simple;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import fr.maboite.webshop.model.Reservation;

@Component
public class ReservationDao {

    public Reservation get(Integer id) {
        System.out.println("get ReservationDao numéro: " + id);

        Reservation reservation = new Reservation();
        reservation.setId(id);
        reservation.setNom("Reservation Bidon");
        reservation.setDebut(LocalDate.of(2023, 4, 12));
        reservation.setFin( LocalDate.now());
        return reservation;
    }

    public Reservation save(Reservation reservation) {
        System.out.println("save ReservationDao numéro: " + reservation);
        return reservation;
    }
}
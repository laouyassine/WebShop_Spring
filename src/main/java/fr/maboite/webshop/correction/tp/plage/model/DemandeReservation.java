package fr.maboite.webshop.correction.tp.plage.model;

import java.time.LocalDate;

public class DemandeReservation {
	private String nom;
	private LocalDate debut;
	private LocalDate fin;
	private String plage;
	private String hotel;
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

	public LocalDate getDebut() {
		return debut;
	}

	public void setDebut(LocalDate debut) {
		this.debut = debut;
	}

	public LocalDate getFin() {
		return fin;
	}

	public void setFin(LocalDate fin) {
		this.fin = fin;
	}

	public String getPlage() {
		return plage;
	}

	public void setPlage(String plage) {
		this.plage = plage;
	}

	public String getHotel() {
		return hotel;
	}

	public void setHotel(String hotel) {
		this.hotel = hotel;
	}






}

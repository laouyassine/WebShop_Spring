package fr.maboite.webshop.correction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
public class MonPremierService {

	private String nom = "nom par défaut";

	@Autowired
	private MonPremierDao monPremierDao;

	public void coucou() {
		System.out.println("Je suis le service");
	}

	public MonPremierService() {
		System.out.println("Je vis !!!");
	}

	public MonPremierDao getMonPremierDao() {
		return monPremierDao;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}


}

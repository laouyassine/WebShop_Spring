package fr.maboite.webshop.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Planete {
    @NotNull(message = "Lid ne peut pas être nul")
    private int id;
    
    @NotEmpty
    @Size(max = 10)
    private String nom;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
    
    
}

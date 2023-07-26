package fr.maboite.webshop.mvc.rest.dto;

import fr.maboite.webshop.model.Example;

public class ExampleRestDto {
	private Long id;

	private String nom;

	private Float taille;

	public ExampleRestDto() {
	}

	public ExampleRestDto(Example example) {
		this.id = example.getId();
		this.nom = example.getNom();
		this.taille = example.getTaille();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Float getTaille() {
		return taille;
	}

	public void setTaille(Float taille) {
		this.taille = taille;
	}

	public void remplisExample(Example example) {
		// TODO Auto-generated method stub

	}

	public Example toExample() {
		Example example = new Example();
		example.setId(this.id);
		example.setNom(this.nom);
		example.setTaille(this.taille);
		return example;
	}

}

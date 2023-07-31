package fr.maboite.webshop.correction.tp.plage.dao;

import org.springframework.stereotype.Service;

import fr.maboite.webshop.correction.tp.plage.model.Plage;

@Service
public class PlageDao {

	public Plage save(Plage plage) {
		System.out.println("Sauvegarde d'une plage dans le DAO");
		if (plage.getId() == null) {
			plage.setId(1);
		}
		return plage;
	}

	public Plage get(Integer id) {
		System.out.println("Récupération d'une plage dans le DAO");
		Plage plage = new Plage();
		plage.setId(1);
		plage.setNom("beau soleil");
		return plage;
	}

}

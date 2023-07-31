package fr.maboite.webshop.correction.tp.plage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.maboite.webshop.correction.tp.plage.dao.PlageDao;
import fr.maboite.webshop.correction.tp.plage.model.Plage;

@Service
public class PlageService {

	private static final String PLAGE_SUFFIXE = "plage";
	@Autowired
	private PlageDao plageDao;

	public Plage save(Plage plage) {
		System.out.println("Sauvegarde d'une plage dans le service");
		return this.plageDao.save(plage);
	}

	public Plage get(Integer id) {
		System.out.println("Récupération d'une plage dans le service");
		return this.plageDao.get(id);

	}

	public boolean isPlage(String plage) {
		return plage.endsWith(PLAGE_SUFFIXE);
		// return plage.toLowerCase().endsWith(PLAGE_SUFFIXE);
	}

}

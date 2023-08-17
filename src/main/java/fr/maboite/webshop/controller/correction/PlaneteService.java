package fr.maboite.webshop.controller.correction;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import fr.maboite.webshop.model.Planete;

@Component
public class PlaneteService {

	private Map<Integer, Planete> planetes = new HashMap<>();


	public PlaneteService() {
		Planete mercure = new Planete();
		mercure.setId(1);
		mercure.setNom("Mercure");
		this.planetes.put(1, mercure);

		Planete venus = new Planete();
		venus.setId(2);
		venus.setNom("Venus");
		this.planetes.put(2, venus);

		Planete terre = new Planete();
		terre.setId(3);
		terre.setNom("Terre");
		this.planetes.put(3, terre);
	}

	public Planete getById(Integer id) {
		return this.planetes.get(id);
	}

	public Collection<Planete> getAll() {
		return this.planetes.values();
	}
	public void save(Planete planete) {
		this.planetes.put(planete.getId(), planete);
	}

}
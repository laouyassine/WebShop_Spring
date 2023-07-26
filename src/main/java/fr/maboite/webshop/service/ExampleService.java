package fr.maboite.webshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import fr.maboite.webshop.dao.spring.ExampleDao;
import fr.maboite.webshop.model.Example;

/**
 * Service pour l'entité Example.
 * Contient de nombreux appels passés au DAO
 * pour illustrer les capacités de Spring Data JPA
 */
@Component
public class ExampleService {

	@Autowired
	private ExampleDao exampleSpringDao;

	/**
	 * Sauvegarde example
	 * @param example
	 */
	@Transactional
	public Example save(Example example) {
		return this.exampleSpringDao.save(example);
	}

	/**
	 * Récupère Example par son id, ou null
	 * si aucune ligne ne correspond en base.
	 * @param id
	 * @return
	 */
	public Example findById(Long id) {
		return this.exampleSpringDao.findById(id).orElse(null);
	}

	/**
	 * Renvoie tous les Example présents en base
	 */
	public Iterable<Example> findAll(){
		return this.exampleSpringDao.findAll();
	}
	
	/**
	 * Compte toutes les lignes d'Example présentes en base
	 * @return
	 */
	public long count() {
		return this.exampleSpringDao.count();
	}

	/**
	 * Supprime un Example par son identifiant.
	 * @param id
	 */
	@Transactional
	public void delete(Long id) {
		this.exampleSpringDao.deleteById(id);
	}

	/**
	 * Récupère Example par son id, ou null
	 * si aucune ligne ne correspond en base.
	 * @param id
	 * @return
	 */
	public List<Example> findByNom(String nom) {
		return this.exampleSpringDao.maMethodeDeRechercheAvecUneQueryExplicite(nom);
	}
	
	public void ecritDansUnFichierExcel() {
		List<Example> pablos 
		= this.exampleSpringDao.maMethodeDeRechercheAvecUneQueryExplicite("pablo");
		pablos.addAll(this.exampleSpringDao.findByNom("francois"));
		pablos.add(this.findById(434l));
		for (Example example : pablos) {
			//ecrit dans le fichier Excel
		}
	}

}
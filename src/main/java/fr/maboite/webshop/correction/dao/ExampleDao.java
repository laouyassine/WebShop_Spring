package fr.maboite.webshop.correction.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.maboite.webshop.model.Example;

@Repository
public interface ExampleDao extends CrudRepository<Example, Long> {

	List<Example> findByNom(String nom);

	List<Example> findByNomIgnoreCase(String nom);

	List<Example> findByNomAndTaille(String nom, Float taille);

	List<Example> findByNomContainingIgnoreCase(String nom);

	List<Example> findByCategoryNom(String nomCategorie);

	
	@Query("from Example where nom = :nom")
	List<Example> findByNom2(@Param("nom") String nom);

	@Query("from Example where nom = :nom or taille = :taille ")
	List<Example> findByNomAndTaille2(@Param("nom") String nom, @Param("taille") Float taille);

	@Query("from Example order by taille desc")
	List<Example> findAllSortByTaille();

}
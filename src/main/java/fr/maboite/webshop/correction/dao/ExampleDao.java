package fr.maboite.webshop.correction.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.maboite.webshop.model.Example;

@Repository
public interface ExampleDao extends CrudRepository<Example, Long> {

}

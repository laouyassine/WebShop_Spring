package fr.maboite.webshop.correction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.maboite.webshop.correction.dao.ExampleDao;
import fr.maboite.webshop.model.Example;

@Service
public class ExampleService {

	@Autowired
	private ExampleDao exampleDao;

	public Example save(Example example) {
		return this.exampleDao.save(example);
	}

	public Iterable<Example> getAll() {
		return this.exampleDao.findAll();
	}

	public Example getById(Long id) {
		return this.exampleDao.findById(id).get();
	}

}

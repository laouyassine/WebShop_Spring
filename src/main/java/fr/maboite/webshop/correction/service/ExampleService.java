package fr.maboite.webshop.correction.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import fr.maboite.webshop.correction.dao.CategoryDao;
import fr.maboite.webshop.correction.dao.ExampleDao;
import fr.maboite.webshop.model.Category;
import fr.maboite.webshop.model.Example;

@Component
public class ExampleService {


	@Autowired
	private ExampleDao exampleDao;

	@Autowired
	private CategoryDao categoryDao;

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	@Autowired
	private AutreService autreService;

	public Example save(Example example) {
		return this.exampleDao.save(example);
	}

	public Iterable<Example> getAll() {
		return this.exampleDao.findAll();
	}

	public Example getById(Long id) {
		return this.exampleDao.findById(id).get();
	}

	public List<Example> getByNom(String nom) {
		return this.exampleDao.findByNomContainingIgnoreCase(nom);
	}

	public List<Example> toto(String nom) {
		return this.exampleDao.findByNom2(nom);
	}

	public List<Example> findByCategory(String categoryName) {
		return this.exampleDao.findByCategoryNom(categoryName);
	}

	public Example associateWithCategorySansAtTransactional(Example example, String categoryName) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		EntityTransaction tx = entityManager.getTransaction();
		try {
			Category category = this.categoryDao.findByNom(categoryName);
			example.setCategory(category);
			Example exampleSauvegarde = this.exampleDao.save(example);
			tx.commit();
			return exampleSauvegarde;
		} catch (Exception e) {
			tx.rollback();
			throw e;
		}
	}

	@Transactional
	public Example associateWithCategoryAvecAtTransactional(Example example, String categoryName) {
		Category category = this.categoryDao.findByNom(categoryName);
		example.setCategory(category);
		return this.exampleDao.save(example);
	}

	@Transactional
	public void coucou() {
		Example example1 = this.exampleDao.findById(1l).get();
		Example example2 = this.exampleDao.findById(2l).get();

		example1.setNom("1000");
		example2.setNom("2000");

		this.exampleDao.save(example1);
		this.exampleDao.save(example2);

		throw new NullPointerException();

	}


}

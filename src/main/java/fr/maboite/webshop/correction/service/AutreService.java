package fr.maboite.webshop.correction.service;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import fr.maboite.webshop.correction.dao.CategoryDao;
import fr.maboite.webshop.correction.dao.ExampleDao;
import fr.maboite.webshop.model.Category;
import fr.maboite.webshop.model.Example;

@Component
public class AutreService {

	@Autowired
	private ExampleDao exampleDao;

	@Autowired
	private CategoryDao categoryDao;

	@Autowired
	private EntityManagerFactory emf;

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Example associateWithCategoryAvecAtTransactional(Example example, String categoryName) {
		Category category = this.categoryDao.findByNom(categoryName);
		example.setCategory(category);
		category.setNom("mince");
		this.categoryDao.save(category);
		Example exampleSauvegarde = this.exampleDao.save(example);
		return exampleSauvegarde;
	}



}

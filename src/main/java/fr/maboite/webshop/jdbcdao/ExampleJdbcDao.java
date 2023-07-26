package fr.maboite.webshop.jdbcdao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import fr.maboite.webshop.model.Example;

/**
 * DAO pour la classe Example.
 * Se base sur spring JdbcTemplate
 */
@Component
public class ExampleJdbcDao {

	private JdbcTemplate jdbcTemplateObject;

	/**
	 * La Datasource est nécessaire pour instancier l'unique
	 * JdbcTemplate de ce DAO
	 * @param dataSource
	 */
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	/**
	 * Supprime la table EXAMPLE si elle existe, puis la recréee.
	 */
	public void dropAndCreateTable() {
		jdbcTemplateObject.execute("DROP TABLE IF EXISTS EXAMPLE");
		jdbcTemplateObject.execute("CREATE TABLE EXAMPLE(ID INTEGER PRIMARY KEY, NOM VARCHAR(255))");
	}

	/**
	 * Renvoie tous les Example en base de données
	 * @return
	 */
	public List<Example> findAll() {
		return jdbcTemplateObject.query(
				"SELECT * FROM EXAMPLE", new ExampleRowMapper());
	}

	/**
	 * Insère example en base de données
	 * @param example
	 * @return
	 */
	public int insert(Example example) {
		return jdbcTemplateObject.update(
				"INSERT INTO EXAMPLE (ID, NOM) VALUES (?, ?)", example.getId(), example.getNom());
	}

	/**
	 * Renvoie tous les Example ayant nom comme nom en base de données
	 * @return
	 */
	public List<Example> findByNom(String nom) {
		return jdbcTemplateObject.query(
				"SELECT * FROM EXAMPLE WHERE nom = ?",
				new ExampleRowMapper(), 
				nom);
	}
	
}

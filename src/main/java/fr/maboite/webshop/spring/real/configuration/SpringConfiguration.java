package fr.maboite.webshop.spring.real.configuration;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

//Déclare un bean de configuration
//ce bean va créer d'autres instances
@Configuration

//Active les Repositories JPA trouvés
//dans le package fourni en paramètre
@EnableJpaRepositories("fr.maboite.webshop.correction.dao")

//Scanne les composants trouvés dans le
//package fourni en paramètre
@ComponentScan("fr.maboite.webshop.correction.service")
public class SpringConfiguration {

	//Définit le nom de l'unité de persistence 
	private static final String PERSISTENCE_UNIT_NAME = "persistence-unit";

	/**
	 * Crée une entityManagerFactory, utilisée pour 
	 * créer des entityManagers
	 * @return
	 */
	@Bean
	public EntityManagerFactory entityManagerFactory() {
		return Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	}

	/**
	 * Crée un transactionManager, utilisé
	 * par Spring Data pour gérer les transactions
	 * via @Transactional
	 * @param emf
	 * @return
	 */
	@Bean(name = "transactionManager")
	public PlatformTransactionManager dbTransactionManager(EntityManagerFactory emf) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(
				emf);
		return transactionManager;
	}

}
package fr.maboite.webshop.correction.spring.application;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.maboite.webshop.jdbcdao.ExampleJdbcDao;
import fr.maboite.webshop.jdbcdao.ExampleJdbcNamedDao;
import fr.maboite.webshop.model.Example;
import fr.maboite.webshop.spring.simple.configuration.SpringJdbcTemplateConfiguration;

public class SpringJdbcTemplateApplication {

	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext appContext 
				= new AnnotationConfigApplicationContext(SpringJdbcTemplateConfiguration.class)) {
			ExampleJdbcDao exampleJdbcDao 
				= appContext.getBean(ExampleJdbcDao.class);
			exampleJdbcDao.dropAndCreateTable();
			Example example = new Example();
			example.setId(1l);
			String nomExemple = "Mon exemple";
			example.setNom(nomExemple);
			exampleJdbcDao.insert(example);
			exampleJdbcDao.findByNom(nomExemple).forEach(e -> System.out.println("J'ai trouvé l'exemple avec l'id : %1$s et le nom %2$s".formatted(e.getId(), e.getNom())));

			ExampleJdbcNamedDao exampleJdbcNamedDao 
				= appContext.getBean(ExampleJdbcNamedDao.class);
			exampleJdbcNamedDao.findByNom(nomExemple).forEach(e -> System.out.println("Avec le JdbcNamed, j'ai trouvé l'exemple avec l'id : %1$s et le nom %2$s".formatted(e.getId(), e.getNom())));
		}
		
		//Récupérer une instance de MonControleurWeb 
	
//		try (AnnotationConfigApplicationContext appContext = 
//				new AnnotationConfigApplicationContext(SpringConfiguration.class)) {
//			MonControleurWeb monControleurWeb = appContext.getBean(MonControleurWeb.class);	
//			
//			System.out.println(monControleurWeb.getMonService().getMonDao());
//			monControleurWeb.getMonService().getMonDao().save(null);
//			
//		}
	
	
	}

}
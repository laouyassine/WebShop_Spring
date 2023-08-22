package fr.maboite.webshop.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.maboite.webshop.service.MonDeuxiemeService;
import fr.maboite.webshop.service.MonPremierDao;
import fr.maboite.webshop.service.MonPremierService;
import fr.maboite.webshop.spring.simple.configuration.SpringSimpleConfiguration;

public class SpringSimpleApplicationWithConfiguration {

	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(
				SpringSimpleConfiguration.class)) {
			System.out.println("J'ai démarré le contexte");

			appContext.getBean(MonDeuxiemeService.class).coucou();

			MonPremierService monPremierServiceVariable1 = appContext.getBean(MonPremierService.class);
			monPremierServiceVariable1.setNom("nom 1");

			monPremierServiceVariable1.coucou();
			monPremierServiceVariable1.getMonPremierDao().coucou();
			appContext.getBean(MonPremierDao.class).coucou();


			MonPremierService monPremierServiceVariable2 = appContext.getBean(MonPremierService.class);
			System.out.println("Le nom de monPremierServiceVariable2 vaut : " + monPremierServiceVariable2.getNom());

			System.out.println(
					"Est-ce qu'il n'y a qu'une seule instance de la classe "
							+ " MonPremierService dans le contexte Sprint ? "
							+ (monPremierServiceVariable1 == monPremierServiceVariable2));

		}
	}

}

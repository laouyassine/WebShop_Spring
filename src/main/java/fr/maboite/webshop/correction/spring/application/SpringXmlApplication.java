package fr.maboite.webshop.correction.spring.application;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.maboite.webshop.xmlservice.DemonstrationService;

/**
 * Lancement d'un contexte Spring configuré grâce à un fichier XML (de moins en
 * moins utilisé, mais toujours aussi fonctionnel).
 */
public class SpringXmlApplication {

	public static void main(String[] args) throws InterruptedException {
		try (ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("spring-context-old.xml")) {
			DemonstrationService demonstrationService = (DemonstrationService) appContext
					.getBean("demonstrationService");
			demonstrationService.getDemonstrationDao().test();
		}
	}
}

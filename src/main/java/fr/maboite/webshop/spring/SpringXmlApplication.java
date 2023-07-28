package fr.maboite.webshop.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.maboite.webshop.xmlservice.DemonstrationService;

public class SpringXmlApplication {

	public static void main(String[] args) throws InterruptedException {
		try (ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("spring-context-old.xml")) {
			DemonstrationService demonstrationService = (DemonstrationService) appContext
					.getBean("demonstrationService");
			demonstrationService.getDemonstrationDao().test();
		}
	}
}

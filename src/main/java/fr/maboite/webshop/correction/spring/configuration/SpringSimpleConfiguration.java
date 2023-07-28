package fr.maboite.webshop.correction.spring.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import fr.maboite.webshop.correction.service.MonDeuxiemeService;

//Déclare un bean de configuration
//ce bean va créer d'autres instances
@Configuration

//Scanne les composants trouvés dans le
//package fourni en paramètre
@ComponentScan("fr.maboite.webshop.correction")
@PropertySource("classpath:example-application.properties")
public class SpringSimpleConfiguration {

	@Bean
	public MonDeuxiemeService createService() {
		MonDeuxiemeService monDeuxiemeService = new MonDeuxiemeService();
		monDeuxiemeService.setValue(3);
		return monDeuxiemeService;
	}

}
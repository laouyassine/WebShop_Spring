package fr.maboite.webshop.spring.simple.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//Déclare un bean de configuration
//ce bean va créer d'autres instances
@Configuration

//Scanne les composants trouvés dans le
//package fourni en paramètre
@ComponentScan("mettre-ici-un-nom-de-package-a-scanner")
public class SpringSimpleConfiguration {

}
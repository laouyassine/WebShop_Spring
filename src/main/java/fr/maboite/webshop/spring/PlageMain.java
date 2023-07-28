package fr.maboite.webshop.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.maboite.webshop.model.Plage;
import fr.maboite.webshop.service.PlageService;
import fr.maboite.webshop.spring.simple.configuration.SpringSimpleConfiguration;

import java.time.LocalDate;

public class PlageMain {

    public static void main(String[] args) {

        // Démarre le contexte Spring
        try (AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(
                SpringSimpleConfiguration.class)) {
            System.out.println("Contexte Spring démarré");

            // Récupération du bean instancié par Spring
            PlageService plageService = appContext.getBean(PlageService.class);

            // Opérations sur les objets ...
            Plage plage = new Plage();
            plage.setNom("Plage Bidon");

            Plage savedPlage = plageService.save(plage);
            System.out.println("Plage sauvegardée : " + savedPlage);

            Integer plageId = savedPlage.getId();
            Plage retrievedPlage = plageService.get(plageId);
            System.out.println("Plage récupérée : " + retrievedPlage);

            // Calcul de la durée entre deux dates
            LocalDate debut = LocalDate.now();
            LocalDate fin = LocalDate.now().plusDays(7);
            long dureeEnJours = plageService.getDureeEnJours(debut, fin);
            System.out.println("Durée en jours : " + dureeEnJours);
        }

    }

}

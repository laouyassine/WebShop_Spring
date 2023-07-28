package fr.maboite.webshop.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import fr.maboite.webshop.spring.simple.configuration.SpringSimpleConfiguration;

@SpringJUnitConfig(SpringSimpleConfiguration.class) 
public class PlageServiceTest {

    @Autowired
    private PlageService plageService;

    @Test
    public void testGetDureeEnJours() {
        LocalDate debut = LocalDate.of(2023, 7, 1);
        LocalDate fin = LocalDate.of(2023, 7, 10);
        long dureeEnJours = plageService.getDureeEnJours(debut, fin);
        assertEquals(9, dureeEnJours);

    }
}

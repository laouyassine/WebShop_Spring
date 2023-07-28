package fr.maboite.webshop.service;

import org.springframework.stereotype.Component;

import fr.maboite.webshop.model.Plage;

@Component
public class PlageDao {

    public Plage get(Integer id) {
        System.out.println("get PlageDao numéro: " + id);

        Plage plage = new Plage();
        plage.setId(id);
        plage.setNom("Plage Bidon");
        return plage;
    }

    public Plage save(Plage plage) {
        System.out.println("save PlageDao numéro: " + plage);
        return plage;
    }
}

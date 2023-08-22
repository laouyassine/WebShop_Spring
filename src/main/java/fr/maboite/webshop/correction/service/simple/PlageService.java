package fr.maboite.webshop.correction.service.simple;
import fr.maboite.webshop.model.Plage;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PlageService {

    private final PlageDao plageDao;

    @Autowired
    public PlageService(PlageDao plageDao) {
        this.plageDao = plageDao;
    }
    
    public Plage get(Integer id) {
        return plageDao.get(id);
    }

    public Plage save(Plage plage) {
        return plageDao.save(plage);
    }
    
    public long getDureeEnJours(LocalDate debut, LocalDate fin) {
        if (debut == null || fin == null) {
            throw new IllegalStateException("Les dates de début et de fin doivent être définies.");
        }
        return ChronoUnit.DAYS.between(debut, fin);
    }

}

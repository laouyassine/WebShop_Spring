package fr.maboite.webshop.correction.service.simple;
import fr.maboite.webshop.model.Hotel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class HotelService {

    private final HotelDao hotelDao;

    @Autowired
    public HotelService(HotelDao hotelDao) {
        this.hotelDao = hotelDao;
    }
    
    public Hotel get(Integer id) {
        return hotelDao.get(id);
    }

    public Hotel save(Hotel hotel) {
        return hotelDao.save(hotel);
    }
}

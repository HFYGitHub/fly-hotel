package com.hfy.flyhotel;

import com.hfy.flyhotel.Service.HotelService;
import com.hfy.flyhotel.Service.LoginerService;
import com.hfy.flyhotel.entity.Hotel;
import com.hfy.flyhotel.entity.Loginer;
import com.hfy.flyhotel.repository.HotelRepository;
import com.hfy.flyhotel.repository.LoginerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Testll {
    @Autowired
    LoginerRepository loginerRepository;

    @Autowired
    HotelRepository hotelRepository;

    @Autowired
    HotelService hotelService;

    @Test
    public void ijj(){
        String s = "双人房";
        List<Hotel> hotels = hotelRepository.findByType(s);
        for (Hotel hotel : hotels) {
            System.out.println(hotel);
        }
    }
}

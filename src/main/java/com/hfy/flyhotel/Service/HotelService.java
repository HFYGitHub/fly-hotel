package com.hfy.flyhotel.Service;

import com.hfy.flyhotel.entity.Hotel;
import com.hfy.flyhotel.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelService {
    @Autowired
    HotelRepository hotelRepository;

    public void addHotel(Hotel hotel) {
        hotelRepository.save(hotel);
    }

    public void delHotel(Integer id){
        hotelRepository.deleteById(id);
    }

    public Hotel findHotelById(Integer id) {
        Hotel hotel = hotelRepository.findById(id).get();
        return hotel;
    }
}

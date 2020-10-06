package com.hfy.flyhotel.Service;

import com.hfy.flyhotel.entity.Hotel;
import com.hfy.flyhotel.entity.User;
import com.hfy.flyhotel.repository.HotelRepository;
import com.hfy.flyhotel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class HotelToUserService {
    @Autowired
    HotelRepository hotelRepository;

    @Autowired
    UserRepository userRepository;

    public void addHotelToUser(User user, Hotel hotel){
        user.getHotels().add(hotel);
        hotelRepository.save(hotel);
        userRepository.save(user);
    }

    @Transactional
    public void findHotelByUserId(){
        User user = userRepository.findById(1).get();
        System.out.println(user.getHotels());

    }

    @Transactional
    public void deleteHotelByUserName(User user,Hotel hotel){
        user.setHotels(null);
    }
}

package com.hfy.flyhotel.controller;

import com.hfy.flyhotel.entity.Hotel;
import com.hfy.flyhotel.entity.User;
import com.hfy.flyhotel.repository.HotelRepository;
import com.hfy.flyhotel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
public class UserBookHotelController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    HotelRepository hotelRepository;

    @GetMapping("/hotel/book/{id}")
    public ModelAndView toBook(@PathVariable("id") Integer id){
        Hotel hotel = hotelRepository.findById(id).get();
        ModelAndView mv = new ModelAndView();
        mv.addObject("hotel",hotel);
        mv.setViewName("hotel/addUser");
        return mv;
    }

    @PostMapping("/book")
    public ModelAndView addUserToHotel(Hotel hotel,User user){
        user.getHotels().add(hotel);
        Hotel hotel1 = hotelRepository.save(hotel);
        User user1 = userRepository.save(user);

        List<User> users = userRepository.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("users",users);
        mv.setViewName("user/list");
        return mv;
    }



}

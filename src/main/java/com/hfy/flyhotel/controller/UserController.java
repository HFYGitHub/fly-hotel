package com.hfy.flyhotel.controller;

import com.hfy.flyhotel.entity.Hotel;
import com.hfy.flyhotel.entity.User;
import com.hfy.flyhotel.repository.HotelRepository;
import com.hfy.flyhotel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Set;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    HotelRepository hotelRepository;

    //用户查询
    @GetMapping("/users")
    public ModelAndView findUser(){
        List<User> users = userRepository.findAll();
        for (User user : users) {
            System.out.println(user);
        }
        ModelAndView mv = new ModelAndView();
        mv.addObject("users",users);
        mv.setViewName("user/list");
        return mv;
    }



    //根据id查找用户
    @GetMapping("/user/{id}")
    public ModelAndView getHotel(@PathVariable("id") Integer id){
        User user = userRepository.findById(id).get();
        ModelAndView mv = new ModelAndView();
        mv.addObject("user",user);
        mv.setViewName("user/add");
        return mv;
    }

    //根据名字查找用户
    @GetMapping("/userNameBy")
    public ModelAndView findUserByName(HttpServletRequest request){
        List<User> users = userRepository.findByName(request.getParameter("name"));
        ModelAndView mv = new ModelAndView();
        mv.addObject("users",users);
        mv.setViewName("user/list");
        return mv;
    }

    //根据身份证查找用户
    @GetMapping("/userTelBy")
    public ModelAndView findUserByIdNumber(HttpServletRequest request){
        String s = request.getParameter("tel");
        List<User> users = userRepository.findByTel(s);
        ModelAndView mv = new ModelAndView();
        mv.addObject("users",users);
        mv.setViewName("user/list");
        return mv;
    }


    //删除用户
    @PostMapping("/user/{id}")
    public ModelAndView deleteEmployee(@PathVariable("id") Integer id){
        User user = userRepository.findById(id).get();
        Set<Hotel> hotels = user.getHotels();
        for (Hotel hotel : hotels) {
            hotel.setStatus("空闲中");
        }
        user.setHotels(null);
        userRepository.deleteById(id);

        List<User> users = userRepository.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("users",users);
        mv.setViewName("user/list");
        return mv;
    }


}

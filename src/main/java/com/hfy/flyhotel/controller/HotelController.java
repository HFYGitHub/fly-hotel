package com.hfy.flyhotel.controller;

import com.hfy.flyhotel.entity.Hotel;
import com.hfy.flyhotel.entity.Hotel;
import com.hfy.flyhotel.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@RestController
public class HotelController {
    @Autowired
    HotelRepository hotelRepository;

    //酒店查询
    @GetMapping("/hotels")
    public ModelAndView findUser(){
        List<Hotel> hotels = hotelRepository.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("hotels",hotels);
        mv.setViewName("hotel/list");
        return mv;
    }

    //跳转酒店添加页面
    @GetMapping("/hotel")
    public ModelAndView toAddUser(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hotel/add");
        return mv;
    }

    //添加酒店
    @PostMapping("/hotel")
    public ModelAndView addUser(Hotel hotel, @RequestParam("images") MultipartFile file, HttpServletRequest request) throws IOException {
        String upload = upload(file, request);
        hotel.setImage(upload);
        Hotel hotel1 = hotelRepository.save(hotel);
        List<Hotel> hotels = hotelRepository.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("hotels",hotels);
        mv.setViewName("hotel/list");
        return mv;
    }

    //根据id查找酒店
    @GetMapping("/hotel/{id}")
    public ModelAndView getHotel(@PathVariable("id") Integer id){
        Hotel hotel = hotelRepository.findById(id).get();
        System.out.println(hotel);
        ModelAndView mv = new ModelAndView();
        mv.addObject("hotel",hotel);
        mv.setViewName("hotel/add");
        return mv;
    }

    //删除酒店
    @PostMapping("/hotel/{id}")
    public ModelAndView deleteEmployee(@PathVariable("id") Integer id){
        hotelRepository.deleteById(id);
        List<Hotel> hotels = hotelRepository.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("hotels",hotels);
        mv.setViewName("hotel/list");
        return mv;
    }


    //图片文件上传
    public String upload(MultipartFile file, HttpServletRequest request) throws IOException {
        //文件保存路径，默认为根目录下
        String Path = "src/main/resources/static/images/";
        String fileName =  file.getOriginalFilename();
        String filePath = Path + fileName;
        String fileURL = request.getScheme() + "://" + request.getServerName()
                + ":" + request.getServerPort() + "/"
                + Path.substring(Path.lastIndexOf('i')) + fileName ;
        System.out.println(fileName);
        System.out.println(filePath);
        System.out.println(fileURL);
        try {
            BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(filePath));
            outputStream.write(file.getBytes());
            outputStream.flush();
            outputStream.close();
            return fileURL;
        }catch (Exception e){
            e.printStackTrace();
        }
        return "上传失败";
    }


}

package com.hfy.flyhotel.controller;

import com.hfy.flyhotel.entity.Hotel;
import com.hfy.flyhotel.entity.User;
import com.hfy.flyhotel.repository.HotelRepository;
import com.hfy.flyhotel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
public class HotelController {
    @Autowired
    HotelRepository hotelRepository;

    @Autowired
    UserRepository userRepository;

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

    //根据房间类型查找酒店
    @GetMapping("/hotelTypeBy/{type}")
    public ModelAndView findHotelByType(@PathVariable("type") String type){
        List<Hotel> hotels = hotelRepository.findByType(type);
        ModelAndView mv = new ModelAndView();
        mv.addObject("hotels",hotels);
        mv.setViewName("hotel/list");
        return mv;

    }

    //根据房间状态查找酒店
    @GetMapping("/hotelStatusBy/{status}")
    public ModelAndView findHotelByStatuse(@PathVariable("status") String status){
        List<Hotel> hotels = hotelRepository.findByStatus(status);
        ModelAndView mv = new ModelAndView();
        mv.addObject("hotels",hotels);
        mv.setViewName("hotel/list");
        return mv;

    }

    //根据房间号查找酒店
    @GetMapping("/hotelNumberBy")
    public ModelAndView findHotelByNumber(HttpServletRequest request){
        Integer number = Integer.parseInt(request.getParameter("number"));
        List<Hotel> hotels = hotelRepository.findByNumber(number);
        ModelAndView mv = new ModelAndView();
        mv.addObject("hotels",hotels);
        mv.setViewName("hotel/list");
        return mv;

    }

    //删除酒店
    @PostMapping("/hotel/{id}")
    public ModelAndView deleteEmployee(@PathVariable("id") Integer id, Map<String,Object> map){
        Hotel hotel1 = hotelRepository.findById(id).get();
        List<User> users = userRepository.findAll();
        for (User user : users) {
                List hs = new ArrayList(user.getHotels());
                if(hs.get(0).equals(hotel1)){
                    System.out.println(hs);
                    System.out.println(hotel1);
                    System.out.println("无法删除，因为还有用户");
                    map.put("delMsg","无法删除，因为该房间还有用户入住中");

                }else {
                    hotelRepository.deleteById(id);
                }
//

        }
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

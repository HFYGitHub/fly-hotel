package com.hfy.flyhotel.controller;

import com.hfy.flyhotel.Service.LoginerService;
import com.hfy.flyhotel.entity.Loginer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    LoginerService loginerService;

    //登录检查
    @PostMapping(value = "/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map, HttpSession session){

        List<Loginer> loginers = loginerService.findAll();
        for (Loginer loginer : loginers) {
            String names = loginer.getname();
            String pwd = loginer.getpwd();
            System.out.println(names + pwd);
            if(names.equals(username) && pwd.equals(password)){
                session.setAttribute("loginUser", username);
                return "redirect:/index.html";
            }
        }

        map.put("msg","账号密码错误，登录失败！");
        return "login";

    }

    //登出
    @GetMapping(value = "/user/logout")
    public void login(HttpServletResponse response, HttpServletRequest request) throws IOException {
        HttpSession session = request.getSession();
        session.invalidate();
        response.sendRedirect("/login.html");
    }

    @GetMapping(value = "/user/register")
    public void register(HttpServletResponse response, HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("register");
    }


}

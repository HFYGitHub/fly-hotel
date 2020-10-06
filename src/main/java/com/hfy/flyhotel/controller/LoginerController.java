package com.hfy.flyhotel.controller;

import com.hfy.flyhotel.entity.Loginer;
import com.hfy.flyhotel.repository.LoginerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoginerController {
    @Autowired
    LoginerRepository loginerRepository;

    //根据id查找用户
    @GetMapping("/loginer/{id}")
    public Loginer getHotel(@PathVariable("id") Integer id){
        Loginer loginer = loginerRepository.findById(id).get();
        return loginer;
    }

    //添加用户 注册准备
    @GetMapping("/loginer")
    public Loginer insertHotel(Loginer loginer){
        Loginer save = loginerRepository.save(loginer);
        return save;
    }

    //删除用户 注销准备
    @GetMapping("/loginer/delete/{id}")
    public void deleteHotel(@PathVariable("id") Integer id){
        loginerRepository.deleteById(id);
    }

    //更新用户信息
    @GetMapping("/loginer/update")
    public Loginer updateHotel(Loginer loginer){
        Loginer save = loginerRepository.save(loginer);
        return save;
    }

    //查找所有用户
    @GetMapping("/loginer/find")
    public void findHotel(){
        List<Loginer> loginers = loginerRepository.findAll();

        for (Loginer loginer : loginers) {
            System.out.println(loginer);
        }
    }
}

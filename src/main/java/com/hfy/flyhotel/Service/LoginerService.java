package com.hfy.flyhotel.Service;

import com.hfy.flyhotel.entity.Loginer;
import com.hfy.flyhotel.repository.LoginerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginerService {
    @Autowired
    LoginerRepository loginerRepository;

    public void addHotel(Loginer loginer) {
        loginerRepository.save(loginer);
    }

    public void delHotel(Integer id){
        loginerRepository.deleteById(id);
    }

    public Loginer findHotelById(Integer id) {
        Loginer loginer = loginerRepository.findById(id).get();
        return loginer;
    }

    public List<Loginer> findAll(){
        List<Loginer> loginers = loginerRepository.findAll();
        return loginers;
    }
}

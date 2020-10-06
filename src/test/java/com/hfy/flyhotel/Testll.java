package com.hfy.flyhotel;

import com.hfy.flyhotel.Service.LoginerService;
import com.hfy.flyhotel.entity.Loginer;
import com.hfy.flyhotel.repository.LoginerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Testll {
    @Autowired
    LoginerRepository loginerRepository;

    @Test
    public void ijj(){
        List<Loginer> loginers = loginerRepository.findAll();
        for (Loginer loginer : loginers) {
            System.out.println(loginer);
        }
    }
}

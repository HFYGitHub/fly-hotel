package com.hfy.flyhotel.repository;

import com.hfy.flyhotel.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel,Integer>{

    List<Hotel> findByType(String type);

    List<Hotel> findByNumber(Integer number);

    List<Hotel> findByPrice(Double price);

    List<Hotel> findByStatus(String status);



}

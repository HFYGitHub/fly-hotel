package com.hfy.flyhotel.repository;

import com.hfy.flyhotel.entity.Loginer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginerRepository extends JpaRepository<Loginer,Integer> {
}

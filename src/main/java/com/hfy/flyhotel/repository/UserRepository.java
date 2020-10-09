package com.hfy.flyhotel.repository;

import com.hfy.flyhotel.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{

    List<User> findByName(String name);


    List<User> findByTel(String s);
}

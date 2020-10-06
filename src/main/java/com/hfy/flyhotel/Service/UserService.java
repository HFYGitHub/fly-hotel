package com.hfy.flyhotel.Service;

import com.hfy.flyhotel.entity.Hotel;
import com.hfy.flyhotel.entity.User;
import com.hfy.flyhotel.repository.HotelRepository;
import com.hfy.flyhotel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;


    public void addUser(User user) {
        userRepository.save(user);
    }

    public void delUser(Integer id){
        userRepository.deleteById(id);
    }

    public User findUserById(Integer id) {
        User user = userRepository.findById(id).get();
        return user;
    }


}

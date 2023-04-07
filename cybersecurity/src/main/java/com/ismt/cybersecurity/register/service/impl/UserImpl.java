package com.ismt.cybersecurity.register.service.impl;

import com.ismt.cybersecurity.register.model.User;
import com.ismt.cybersecurity.register.repository.UserRepository;
import com.ismt.cybersecurity.register.service.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserImpl implements UserInterface {

    @Autowired
    UserRepository repo;

//    @Autowired
//    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User saveUser(User user){
//        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return repo.save(user);
    }

    @Override
    public User loginUser(User user){
        try {
            return repo.getLogin(user.getUsername(),user.getPassword()).get(0);
        }catch (IndexOutOfBoundsException ex){
            return null;
        }

    }
}

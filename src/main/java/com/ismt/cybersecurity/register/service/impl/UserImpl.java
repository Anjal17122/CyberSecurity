package com.ismt.cybersecurity.register.service.impl;


import com.ismt.cybersecurity.register.model.User;
import com.ismt.cybersecurity.register.repository.UserRepository;
import com.ismt.cybersecurity.register.service.UserInterface;
import com.ismt.cybersecurity.utils.Hashing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

@Service
public class UserImpl implements UserInterface {

    @Autowired
    UserRepository repo;

//    @Autowired
//    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User saveUser(User user) throws NoSuchAlgorithmException, InvalidKeySpecException {
        user.setPassword(Hashing.hash(user.getPassword()));
        return repo.save(user);
    }

    @Override
    public User getUserById(int id){
        return repo.findById(id).orElse(null);
    }

    @Override
    public User loginUser(User user){
        try {
            return repo.getLogin(user.getUsername(),Hashing.hash(user.getPassword())).get(0);
        }catch (IndexOutOfBoundsException ex){
            return null;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

    }
}

package com.ismt.cybersecurity.register.service;

import com.ismt.cybersecurity.register.model.User;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public interface UserInterface {
    User saveUser(User user) throws NoSuchAlgorithmException, InvalidKeySpecException;

    User loginUser(User user);

    User getUserById(int id);
}

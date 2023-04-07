package com.ismt.cybersecurity.register.service;

import com.ismt.cybersecurity.register.model.User;

public interface UserInterface {

    User saveUser(User user);

    User loginUser(User user);
}

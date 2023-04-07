package com.ismt.cybersecurity.register.controller;

import com.ismt.cybersecurity.register.model.User;
import com.ismt.cybersecurity.register.service.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {


    @Autowired
    UserInterface service;


    @GetMapping("/login")
    public String showLoginPage(Model model){
        return "Login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute User user, Model model){
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(
//                        user.getUsername(),
//                        user.getPassword()));
//        if (authentication!=null){
//            return "redirect:/register";
//        }
//        return "Login";
//        System.out.println("ksdjfkasdljfasdjf;askjf");
//        System.out.println("username: "+user.getUsername());
//        System.out.println("password: "+user.getPassword());
        User user1 = service.loginUser(user);
        if (user1!=null){
            return "redirect:/register";
        }
        model.addAttribute("error","Username Password Incorrect");
        return "Login";
    }
}

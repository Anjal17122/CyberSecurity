package com.ismt.cybersecurity.register.controller;

import org.springframework.ui.Model;
import jakarta.servlet.http.HttpServletRequest;
import com.ismt.cybersecurity.register.model.User;
import com.ismt.cybersecurity.register.service.UserInterface;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String login(@ModelAttribute User user, Model model, HttpServletRequest request){
        User user1 = service.loginUser(user);
        if (user1!=null){
            request.getSession().setAttribute("logged_in",true);
            request.getSession().setAttribute("userId",user1.getId());
            return "index";
        }
        model.addAttribute("error","Username Password Incorrect");
        return "Login";
    }
}

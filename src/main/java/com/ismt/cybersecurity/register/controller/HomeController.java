package com.ismt.cybersecurity.register.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String getHomePage(Model model){
//        return "index";
        return "index";
    }
}

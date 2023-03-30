package com.ismt.cybersecurity.register.controller;


import com.ismt.cybersecurity.register.model.User;
import com.ismt.cybersecurity.register.service.UserInterface;
import com.ismt.cybersecurity.utils.CaptchaValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

@Controller
@RequestMapping("/register")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RegisterController {

    @Autowired
    UserInterface service;

    @Autowired
    CaptchaValidation captchaValidation;

    @GetMapping
    public String getRegister(Model model){
        return "Register";
    }

    @PostMapping
    public String register(@ModelAttribute User user, Model model, @RequestParam("g-recaptcha-response") String captcha) throws NoSuchAlgorithmException, InvalidKeySpecException {
        if(captchaValidation.isValidCaptcha(captcha)) {
            service.saveUser(user);
            model.addAttribute("success",true
            );
            return "Register";
        }
        model.addAttribute("captchaError","Please validate captcha");
        return "Register";
    }


}

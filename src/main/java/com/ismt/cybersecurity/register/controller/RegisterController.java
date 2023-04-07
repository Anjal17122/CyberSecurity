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
import java.util.function.IntPredicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


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
            if (validateFiled(user)) {
                String error = validatePassword(user.getPassword());
                if (error==null) {
                    service.saveUser(user);
                    model.addAttribute("success", true
                    );
                    return "Register";
                }else{
                    model.addAttribute("validationError",error);
                }
            }else{
                model.addAttribute("validationError","Please fill all fields");
            }
        }else {
            model.addAttribute("captchaError", "Please validate captcha");
        }
        return "Register";
    }

    public boolean validateFiled(User user){
        if (user.getPassword().equals("")){
            return false;
        }
        if (user.getUsername().equals("")){
            return false;
        }
        if (user.getEmail().equals("")){
            return false;
        }
        if (user.getPhoneNo().equals("")){
            return false;
        }
        if (user.getFullName().equals("")){
            return false;
        }
        return true;
    }

    public String validatePassword(String password){
        Pattern letter = Pattern.compile("[a-zA-z]");
        Pattern digit = Pattern.compile("[0-9]");
        Pattern special = Pattern.compile ("[!@#$%&*()_+=|<>?{}\\[\\]~-]");
        Matcher hasDigit = digit.matcher(password);
        Matcher hasSpecial = special.matcher(password);
        if (password.length()<8){
            return "Password should have Min 8 character";
        }
        if (!hasSpecial.find()){
            return "Password should have special Character";
        }
        if (!hasDigit.find()){
            return "Password should have digits";
        }
        if (!containsLowerCase(password)){
            return "Password should have lowercase letter";
        }
        if (!containsUpperCase(password)){
            return "Password should have uppercase letter";
        }
        return null;

    }

    private boolean containsLowerCase(String value) {
        return contains(value, i -> Character.isLetter(i) && Character.isLowerCase(i));
    }

    private boolean contains(String value, IntPredicate predicate) {
        return value.chars().anyMatch(predicate);
    }

    private boolean containsUpperCase(String value) {
        return contains(value, i -> Character.isLetter(i) && Character.isUpperCase(i));
    }


}

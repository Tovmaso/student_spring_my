package com.example.demo.controllers;

import com.example.demo.models.UserEntity;
import com.example.demo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class RegistrationController {
    UserService userService;
    StudentController studentController;
    @GetMapping("/registration")

    public String registration (Model model){
        model.addAttribute("userEntity", new UserEntity());
        return "registration";
    }

    @PostMapping("/registration")

    public String registration(@ModelAttribute("UserEntity") UserEntity userEntity , Model model){
        userService.saveUser(userEntity);
        return "redirect:/login";
    }
    @GetMapping("/login")
    public String logIn(){
        return "login";
    }
}


package com.moneymanagerapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {

    @GetMapping(value = {"/", "/login"})
    public String login() {
       return  "login";
    }
}

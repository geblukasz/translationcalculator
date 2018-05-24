package com.translationcalculator.translationform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {

    @RequestMapping(value = "/nonono")
    public String welcome(){
        return "index";
    }
}

package com.codeup.spingblog.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class GoToDicePage {
    @GetMapping("/roll-dice")
    public String rollDicePage(){
        return "roll-dice";
    }
}


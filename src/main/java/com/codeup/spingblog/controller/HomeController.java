package com.codeup.spingblog.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

    @Controller
   public class HomeController {
        @GetMapping("/")
        @ResponseBody
        public String hello() {
            return "<h1>This is the landing Page!!</h1>";
        }
    }

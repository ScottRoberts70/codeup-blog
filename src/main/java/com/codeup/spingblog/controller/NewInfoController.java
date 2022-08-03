package com.codeup.spingblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NewInfoController {
    @GetMapping("/new-info")
    public String newInfoForm(){
        return "new-info";
    }

    @PostMapping("/new-info")
    public String newInfoSubmission(@RequestParam(name = "info") String info, Model model) {
        model.addAttribute("info", String.format("Did you hear? %s", info));
        return "/new-info";
    }
}

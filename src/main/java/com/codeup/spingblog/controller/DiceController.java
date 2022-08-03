package com.codeup.spingblog.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DiceController {
    @RequestMapping(path = "/roll-dice/{n}", method = RequestMethod.GET)
    @ResponseBody
    public String randomOne(@PathVariable int n) {
        int die  = (int)(Math.random()* 6) + 1;
        if (n == die) {
            return String.format("<h1>Great job your number %s  matched %s</h1>", n, die);
        } else {
            return String.format("<h1>Sorry your number was %s and the dice rolled a %s</h1>", n, die);
        }
    }
}

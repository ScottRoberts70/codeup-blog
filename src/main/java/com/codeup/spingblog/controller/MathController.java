package com.codeup.spingblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class MathController {
    @GetMapping("/add/{a}/and/{b}")
    @ResponseBody
    public String reportNumber(@PathVariable int a, @PathVariable int b) {
        var sum = a + b;
        return String.format("%s.", sum);
    }

    @GetMapping("/subtract/{a}/from/{b}")
    @ResponseBody
    public String subNumber(@PathVariable int a, @PathVariable int b) {
        var sub = a - b;
        return String.format("%s.", sub);
    }

    @GetMapping("/multiply/{a}/and/{b}")
    @ResponseBody
    public String multiplyNumber(@PathVariable int a, @PathVariable int b) {
        var multiply = a * b;
        return String.format("%s.", multiply);
    }

    @GetMapping("/divide/{a}/by/{b}")
    @ResponseBody
    public String divNumber(@PathVariable int a, @PathVariable int b) {
        var div = a / b;
        return String.format("%s.", div);
    }
}



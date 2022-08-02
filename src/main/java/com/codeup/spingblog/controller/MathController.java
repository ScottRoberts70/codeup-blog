package com.codeup.spingblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class MathController {
    @RequestMapping(path = "/add/{a}/and/{b}", method = RequestMethod.GET)
    @ResponseBody
    public String reportNumber(@PathVariable int a, @PathVariable int b) {
        var sum = a + b;
        return String.format("%s.", sum);
    }

    @RequestMapping(path = "/subtract/{a}/from/{b}", method = RequestMethod.GET)
    @ResponseBody
    public String subNumber(@PathVariable int a, @PathVariable int b) {
        var sub = a - b;
        return String.format("%s.", sub);
    }

    @RequestMapping(path = "/multiply/{a}/and/{b}", method = RequestMethod.GET)
    @ResponseBody
    public String multiplyNumber(@PathVariable int a, @PathVariable int b) {
        var multiply = a * b;
        return String.format("%s.", multiply);
    }

    @RequestMapping(path = "/divide/{a}/by/{b}", method = RequestMethod.GET)
    @ResponseBody
    public String divNumber(@PathVariable int a, @PathVariable int b) {
        return String.format("%d / %d = %d", a, b, a / b);
//        a different way to do it
    }
}



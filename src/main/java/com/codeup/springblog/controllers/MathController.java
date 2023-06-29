package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {
    @GetMapping("/add/{num1}/and/{num2}")
    @ResponseBody
    public String add(@PathVariable int num1, @PathVariable int num2) {
        long sum = num1 + num2;
        return "<h1>The answer is " + sum + "!";
    }

    @GetMapping("/subtract/{num1}/from/{num2}")
    @ResponseBody
    public String subtract(@PathVariable int num1, @PathVariable int num2) {
        long difference = num2 - num1;
        return "<h1>The answer is " + difference + "!";
    }
    @GetMapping("/multiply/{num1}/and/{num2}")
    @ResponseBody
    public String multiply(@PathVariable int num1, @PathVariable int num2) {
        long product = num1 * num2;
        return "<h1>The answer is " + product + "!";
    }

    @GetMapping("/divide/{num1}/by/{num2}")
    @ResponseBody
    public String divide(@PathVariable int num1, @PathVariable int num2) {
        long quotient = num1 / num2;
        return "<h1>The answer is " + quotient + "!";
    }


}

package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Random;

@Controller
public class RollDiceController {
    @GetMapping("/roll-dice")
    public String rollDiceLanding(Model model) {

        return "rollDice";
    }

    @GetMapping("/roll-dice/{num}")
    public String rollDiceLanding(@PathVariable int num, Model model) {
        Random random = new Random();
        int rand = 0;
        while (true){
            rand = random.nextInt(7);
            if(rand !=0) break;
        }
        model.addAttribute("roll", rand);
        System.out.println(rand);
        model.addAttribute("guess", num);

        if(rand == num) {
            model.addAttribute("answer", "Correct!");
        } else {
            model.addAttribute("answer", "Incorrect!");
        }
        return "viewResults";
    }
}

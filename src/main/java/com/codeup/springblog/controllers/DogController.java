package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Dog;
import com.codeup.springblog.models.EmailService;
import com.codeup.springblog.repositories.DogRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor

@Controller
@RequestMapping("/dogs")
public class DogController {
    private DogRepository dogDao;

    private EmailService emailService;

//    @GetMapping
//    @ResponseBody
//    public String create() {
//        return "dogs/create";
//    }

    @GetMapping
    @ResponseBody
    public String index() {
        List<Dog> dogs = dogDao.findAll();

        List<Dog> sDogs = dogDao.searchByName("S");

        System.out.println(sDogs);
        return "Show all dogs here";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public String fetchById(@PathVariable long id) {
        Optional<Dog> optionalDog = dogDao.findById(id);
        if (optionalDog.isEmpty()) {
            return "no dog found. return a 404 instead";
        }
        Dog dog = optionalDog.get();
        return dog.toString();
    }

    @PostMapping("/create")
    @ResponseBody
    public String create(@RequestParam Long id, @RequestParam String dogName, @RequestParam int age, @RequestParam String ownerName) {
//        System.out.println(id);
        Dog dog = new Dog(id, dogName, age);

//        emailService.prepareAndSend(dog, "You saved a new dog", "Your dogs name is: " + dog.getName());
        dogDao.save(dog);
        return "dog created???";
    }

    @GetMapping("/{id}/delete")
    @ResponseBody
    public String delete(@PathVariable Long id) {
        dogDao.deleteById(id);
        return "dog " + id + " deleted";
    }

    @GetMapping("/create")
    public String create() {return "/dogs/create";}
}

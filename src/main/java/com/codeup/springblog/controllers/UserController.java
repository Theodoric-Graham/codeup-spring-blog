package com.codeup.springblog.controllers;

import com.codeup.springblog.models.User;
import com.codeup.springblog.repositories.UserRepository;
import org.springframework.boot.Banner;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private UserRepository userDao;
    private PasswordEncoder passwordEncoder;

    public UserController(UserRepository userDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/sign-up")
    public String showSignupForm(Model model){
        model.addAttribute("user", new User());
        return "users/sign-up";
    }

    @PostMapping("/sign-up")
    public String saveUser(@ModelAttribute User user){
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        userDao.save(user);
        return "redirect:/login";
    }

    @GetMapping("/profile")
    public String fileStack(Model model){
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        loggedInUser.setImage("https://cdn.filestackcontent.com/SsF5qKUTRl6yihUHYX8w");
        model.addAttribute("user", loggedInUser);
        System.out.println(loggedInUser.getImage());
//        System.out.println(loggedInUser.getUsername());
//        System.out.println(loggedInUser.getEmail());
//        System.out.println(loggedInUser.getPassword());
//        System.out.println(loggedInUser.getId());
        return "profile";
    }

    @PostMapping("/profile")
    public String uploadImage(){
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();


        String imageSrc = "";
        return imageSrc;
    }

}


package com.codeup.springblog.controllers;

import com.codeup.springblog.models.EmailService;
import com.codeup.springblog.models.Item;
import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.User;
import com.codeup.springblog.repositories.PostRepository;
import com.codeup.springblog.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor

@Controller
//@RequestMapping(path = "/posts")
public class PostController {

    // These two next steps are often called dependency injection, where we create a Repository instance and initialize it in the controller class constructor.
    private PostRepository postDao;

    private UserRepository userDao;

    private EmailService emailService;


    @GetMapping("/posts")
    public String viewPosts(Model model) {
        List<Post> posts = postDao.findAll();
        model.addAttribute("posts", posts);


        return "index";
    }

    @GetMapping("/posts/{id}")
    public String viewPostsById(@PathVariable Long id, Model model) {
        model.addAttribute("id", id);
        Optional<Post> optionalPost = postDao.findById(id);
        if (optionalPost.isEmpty()) {
            System.out.println("not found");
            return "home";
        }
        model.addAttribute("post", optionalPost.get());

        return "show";
    }

    @GetMapping("/posts/create")
    public String viewPostsCreate(Model model) {
        model.addAttribute("post", new Post());
        return "create";
    }

    @PostMapping("/posts/create")
    public String postsCreate(@ModelAttribute Post post) {
        String title = post.getTitle();
        String body = post.getBody();
        User loggedInUser = userDao.findById(2L).get();
        post.setUser(loggedInUser);
        emailService.prepareAndSend(post, title, body);
        postDao.save(post);
        return "redirect:/posts";

    }

    @GetMapping("/posts/{id}/edit")
    public String viewPostsEdit(@PathVariable Long id, Model model) {
        model.addAttribute("post", postDao.findById(id).get());
        return "create";
    }



}

package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Item;
import com.codeup.springblog.models.Post;
import com.codeup.springblog.repositories.PostRepository;
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
        if(optionalPost.isEmpty()) {
            System.out.println("not found");
            return "home";
        }
//        Post post = new Post("hello this is the first post", "lets see if this works", 1L);
        model.addAttribute("post", optionalPost.get());

        return "show";
    }

    @GetMapping("/posts/create")
    public String viewPostsCreate() {

        return "/create";
    }

    @PostMapping("/posts/create")
    public String postsCreate(@RequestParam String title, @RequestParam String body) {
//        System.out.println(title + body);

        Post post = new Post();
        post.setTitle(title);
        post.setBody(body);
        postDao.save(post);
        return "redirect:/posts";
    }


}

package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/posts")

public class PostController {

    @GetMapping()
    @ResponseBody
    public String viewPosts() {
        return "<h1>This is the posts index page</h1>";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public String viewPostsById(@PathVariable long id) {

        return "<h1>View an individual post, the post id is: " + id + "</h1>";
    }

    @GetMapping("/create")
    @ResponseBody
    public String viewPostsCreate() {

        return "<h1>View the form for creating a post!</h1>";
    }

    @PostMapping("/create")
    @ResponseBody
    public String postsCreate() {

        return "create a new post";
    }

}

package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Item;
import com.codeup.springblog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/posts")

public class PostController {

    @GetMapping()
    public String viewPosts(Model model) {
        List<Post> posts = new ArrayList<>();
        posts.add(new Post ("my day today", "it was pretty good"));
        posts.add(new Post ("my day tomorrow", "it was pretty good"));
        posts.add(new Post ("my day yesterday", "it was pretty good"));
        model.addAttribute("posts", posts);


        return "index";
    }

    @GetMapping("/{id}")
    public String viewPostsById(@PathVariable Long id, Model model) {
        model.addAttribute("id", id);
        Post post = new Post("hello this is the first post", "lets see if this works");
        model.addAttribute("post", post);

        return "show";
    }

    @GetMapping("/create")
    @ResponseBody
    public String viewPostsCreate() {

        return "<form action='/posts/create' method='post'>" +
                "<input type='submit' value='submit'>" +
                "</form>";
    }

    @PostMapping("/create")
    @ResponseBody
    public String postsCreate() {

        return "A new post has been made";
    }


}

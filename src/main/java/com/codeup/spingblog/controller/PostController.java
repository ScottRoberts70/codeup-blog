package com.codeup.spingblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    @GetMapping("/posts")
    public String postsPage(Model model){
        List<Post> posts = new ArrayList<>();
        posts.add(new Post(1L, "Post 1", "Hi this is my post!", "/posts/1"));
        posts.add(new Post(2L, "Post 2", "Their are many like it!", "/posts/2"));
        posts.add(new Post(3L, "Post 3", "..But this one is mine!", "/posts/3"));
        model.addAttribute("posts", posts);
        return "/posts/index";
    }

    @GetMapping("/posts/{id}")
    public String postByIdPage(@PathVariable long id, Model model){
        List<Post> posts = new ArrayList<>();
        posts.add(new Post(1L, "Post1", "Post 1"));
        posts.add(new Post(2L, "Post2", "Post 2"));
        posts.add(new Post(3L, "Post3", "Post 3"));

        model.addAttribute("post", posts.get((int)id - 1));

        return "/posts/show";
    }
}


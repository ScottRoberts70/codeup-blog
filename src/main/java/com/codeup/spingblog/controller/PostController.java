package com.codeup.spingblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
@Controller
public class PostController {

    @RequestMapping(path = "/posts", method = RequestMethod.GET)

    @ResponseBody
    public String thisPage() {
        return ("posts index page");
    }

    @RequestMapping(path = "/posts/{id}", method = RequestMethod.GET)

    @ResponseBody
    public String postsId(@PathVariable String id) {
        return ("view an individual post");
    }

    @RequestMapping(path = "/posts/create", method = RequestMethod.GET)

    @ResponseBody
    public String postsCreate() {
        return ("view the form for creating a post");
    }

    @RequestMapping(path = "/posts/create", method = RequestMethod.POST)

    @ResponseBody
    public String createPost() {
        return ("create a new post");
    }
}

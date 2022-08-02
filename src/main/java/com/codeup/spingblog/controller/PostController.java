package com.codeup.spingblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
@Controller
public class PostController {

    @RequestMapping(path = "/posts", method = RequestMethod.GET)

    public String thisPage() {
        return ("/posts/index");
    }

    @RequestMapping(path = "/posts/{id}", method = RequestMethod.GET)


    public String postsId(@PathVariable String id) {
        return ("/posts/view");
    }

    @RequestMapping(path = "/posts/create", method = RequestMethod.GET)

    public String postsCreate() {
        return ("/posts/create");
    }

    @RequestMapping(path = "/posts/create", method = RequestMethod.POST)

    public String createPost() {
        return null;
    }
}

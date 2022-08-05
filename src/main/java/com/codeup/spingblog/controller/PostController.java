package com.codeup.spingblog.controller;

import com.codeup.spingblog.model.Post;
import com.codeup.spingblog.model.User;
import com.codeup.spingblog.repositories.PostRepository;
import com.codeup.spingblog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

   private PostRepository postsDao;

   private UserRepository usersDao;

    public PostController(PostRepository postsDao, UserRepository usersDao) {
        this.postsDao = postsDao;
        this.usersDao = usersDao;
    }

    @GetMapping("/posts")
    public String postsPage(Model model){
        model.addAttribute("posts", postsDao.findAll());

        return "/posts/index";
    }

        @GetMapping("/posts/create")
        public String createPost(){
            return "/posts/create";
        }


    @PostMapping("posts/create")
    public String savePost(String title, String body){
    if (title != null && body != null) {
        User user = usersDao.getById(1L);
    postsDao.save(new Post(title, body, user));
    }
    return "redirect:/posts";
    }

    @GetMapping("/posts/show")
    public String postByIdPage(){
        return "/posts/show";
    }
    @PostMapping("/posts")
    public String postMethods(Long delete, Long edit, Long show, HttpSession session, Model model){

        if (show != null) {
            Post post = postsDao.getById(show);
            model.addAttribute("post", post);
            return "/posts/show";
        }

        if (edit != null) {
            session.setAttribute("edit", edit);
            return "/posts/edit";
        }

        if (delete != null) {
            Post post = postsDao.getById(delete);
            postsDao.delete(post);
        }
        return "redirect:/posts";
    }

    @GetMapping("/post/edit")
    public String editPostPage(){
        return "/posts/edit";
    }

    @PostMapping("/posts/edit")
    public String editPost( String title, String body, HttpSession session){
        Long id = (Long) session.getAttribute("edit");
        if (title != null && body != null) {
            postsDao.editPost(title, body, id);
        }
        return "redirect:/posts";
    }
//    @PostMapping("/posts")
//    public String singleAd (Long singleAd, Model model) {
//        if (singleAd != null) {
//            Post post = postsDao.getById(singleAd);
//            model.addAttribute("post", post);
//        }
//        return "/posts/show";
//    }
}


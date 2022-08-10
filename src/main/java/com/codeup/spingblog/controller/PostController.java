package com.codeup.spingblog.controller;

import com.codeup.spingblog.model.Post;
import com.codeup.spingblog.model.Tag;
import com.codeup.spingblog.model.User;
import com.codeup.spingblog.repositories.PostRepository;
import com.codeup.spingblog.repositories.TagRepository;
import com.codeup.spingblog.repositories.UserRepository;
import com.codeup.spingblog.services.EmailService;
import org.springframework.security.core.context.SecurityContextHolder;
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

   private TagRepository tagsDao;

    private  EmailService emailService;

    public PostController(PostRepository postsDao, UserRepository usersDao, TagRepository tagsDao, EmailService emailService) {
        this.postsDao = postsDao;
        this.usersDao = usersDao;
        this.tagsDao = tagsDao;
        this.emailService =emailService;
    }

    @GetMapping("/posts")
    public String postsPage(Model model){
        model.addAttribute("posts", postsDao.findAll());

        return "/posts/index";
    }

        @GetMapping("/posts/create")
        public String showCreateForm(Model model){
        model.addAttribute("post", new Post());
            return "/posts/create";
        }
    @PostMapping("/posts/create")
    public String create(@ModelAttribute Post post){
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        post.setUser(currentUser);
         postsDao.save(post);
        emailService.prepareAndSend(usersDao.getById(1L), "Post Created", "Your new post has been created.");
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
            return "redirect:/posts/show";
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
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Long id = (Long) session.getAttribute("edit");
        if (title != null && body != null) {
            postsDao.editPost(title, body, id);
        }
        return "redirect:/posts";
    }
}


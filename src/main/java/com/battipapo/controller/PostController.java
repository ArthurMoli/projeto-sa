package com.battipapo.controller;

import com.battipapo.model.Post;
import com.battipapo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping("/post/list")
    public String findAll(Model model){
        model.addAttribute("posts", postService.findAll());
        return "post/list";
    }

    @GetMapping("/post/add")
    public String add(Model model){
        model.addAttribute("post", new Post());
        return "/post/add";
    }

    @PostMapping("/post/save")
    public String save(Post post, Model model){
        try {
            postService.save(post);
            model.addAttribute("post", post);
            model.addAttribute("isSaved", true);
            return "/post/add";
        } catch (Exception e){
            model.addAttribute("post", post);
            model.addAttribute("isError", true);
            model.addAttribute("error", e.getMessage());
            return "/post/add";
        }
    }

}

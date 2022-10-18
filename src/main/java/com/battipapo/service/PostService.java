package com.battipapo.service;

import com.battipapo.model.Post;

import java.util.List;

public interface PostService {

    public List <Post> findAll();

    public Post findById(Long id);

    public Post save(Post post);
}

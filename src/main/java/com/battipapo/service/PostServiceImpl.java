package com.battipapo.service;

import com.battipapo.model.Post;
import com.battipapo.model.Usuario;
import com.battipapo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;

    public List <Post> findAll(){
        return postRepository.findAll();
    }

    @Override
    public Post findById(Long id){
        Post pos = postRepository.findById(id).get();
        return pos != null ? pos : new Post();
    }

    @Override
    public Post save(Post post){
        try{
            return postRepository.save(post);
        } catch (Exception e){
            throw e;
        }
    }


}

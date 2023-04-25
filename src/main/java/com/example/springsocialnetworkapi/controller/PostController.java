package com.example.springsocialnetworkapi.controller;

import com.example.springsocialnetworkapi.dto.post.PostDto;
import com.example.springsocialnetworkapi.service.post.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    private IPostService postService;
    @PostMapping(value = "/newPost")
    public PostDto createPost(@Valid @RequestBody PostDto model){
        return postService.save(model);
    }
    @PutMapping(value = "/updatePost/{id}")
    public PostDto createPost(@Valid @RequestBody PostDto model, @PathVariable("id") long id){
        model.setId(id);
        return postService.save(model);
    }
    @DeleteMapping(value = "/deletePost")
    public void deletePost(@RequestBody long[] ids){
        postService.delete(ids);
    }

}

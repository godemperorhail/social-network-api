package com.example.springsocialnetworkapi.controller;

import com.example.springsocialnetworkapi.controller.output.PostOutput;
import com.example.springsocialnetworkapi.dto.post.PostDto;
import com.example.springsocialnetworkapi.entity.PostEntity;
import com.example.springsocialnetworkapi.service.post.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    private IPostService postService;

    @GetMapping(value = "/show")
    public PostOutput showPost() {
        PostOutput result = new PostOutput();
        result.setListPost(postService.getListPost());
        return result;
    }

    @PostMapping(value = "/create")
    public PostDto createPost(@Valid @RequestBody PostDto model) {
        return postService.save(model);
    }

    @PutMapping(value = "/update/{id}")
    public PostDto updatePost(@Valid @RequestBody PostDto model, @PathVariable("id") long id) {
        model.setId(id);
        return postService.save(model);
    }

    @DeleteMapping(value = "/delete")
    public void deletePost(@RequestBody long[] ids) {
        postService.delete(ids);
    }

}

package com.example.springsocialnetworkapi.controller.output;

import com.example.springsocialnetworkapi.dto.post.PostDto;

import java.util.ArrayList;
import java.util.List;

public class PostOutput {
    private List<PostDto> listPost=new ArrayList<>();

    public List<PostDto> getListPost() {
        return listPost;
    }

    public void setListPost(List<PostDto> listPost) {
        this.listPost = listPost;
    }
}

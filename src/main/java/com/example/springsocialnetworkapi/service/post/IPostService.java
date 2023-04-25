package com.example.springsocialnetworkapi.service.post;

import com.example.springsocialnetworkapi.dto.post.PostDto;

public interface IPostService {
    PostDto save(PostDto postDto);
    void delete(long[] ids);
}

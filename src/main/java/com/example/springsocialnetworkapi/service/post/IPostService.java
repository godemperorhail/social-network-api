package com.example.springsocialnetworkapi.service.post;

import com.example.springsocialnetworkapi.dto.post.PostDto;
import com.example.springsocialnetworkapi.entity.PostEntity;

import java.awt.print.Pageable;
import java.util.List;


public interface IPostService {
    PostDto save(PostDto postDto);

    void delete(long[] ids);

    List<PostDto> getListPost();

}

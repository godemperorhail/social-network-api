package com.example.springsocialnetworkapi.service.post.impl;

import com.example.springsocialnetworkapi.converter.post.PostConverter;
import com.example.springsocialnetworkapi.dto.post.PostDto;
import com.example.springsocialnetworkapi.entity.PostEntity;
import com.example.springsocialnetworkapi.repository.PostRepository;
import com.example.springsocialnetworkapi.repository.UserRepository;
import com.example.springsocialnetworkapi.service.post.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostServiceImpl implements IPostService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostConverter postConverter;

    @Override
    public PostDto save(PostDto postDto) {
        PostEntity postEntity = new PostEntity();
        if (postDto.getId() != null) {
            PostEntity oldPostEntity = postRepository.findById(postDto.getId()).get();
            postEntity = postConverter.toEntity(postDto, oldPostEntity);
        } else {
            postEntity = postConverter.toEntity(postDto);
        }
        postEntity = postRepository.save(postEntity);
        return postConverter.toDto(postEntity);
    }

    @Override
    public void delete(long[] ids) {
        for (long item : ids) {
            postRepository.deleteById(item);
        }
    }

    @Override
    public List<PostDto> getListPost() {
        List<PostDto> result = new ArrayList<>();
        List<PostEntity> posts = postRepository.findAll();
        for (PostEntity item : posts) {
            PostDto postDto = postConverter.toDto(item);
            result.add(postDto);
        }
        return result;
    }


}

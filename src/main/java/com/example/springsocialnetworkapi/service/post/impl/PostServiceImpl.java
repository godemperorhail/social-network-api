package com.example.springsocialnetworkapi.service.post.impl;

import com.example.springsocialnetworkapi.converter.post.PostConverter;
import com.example.springsocialnetworkapi.dto.post.PostDto;
import com.example.springsocialnetworkapi.entity.PostEntity;
import com.example.springsocialnetworkapi.repository.PostRepository;
import com.example.springsocialnetworkapi.repository.UserRepository;
import com.example.springsocialnetworkapi.service.post.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}

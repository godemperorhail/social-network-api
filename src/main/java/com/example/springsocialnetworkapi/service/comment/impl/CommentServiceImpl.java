package com.example.springsocialnetworkapi.service.comment.impl;

import com.example.springsocialnetworkapi.converter.comment.CommentConverter;
import com.example.springsocialnetworkapi.dto.comment.CommentDto;
import com.example.springsocialnetworkapi.entity.CommentEntity;
import com.example.springsocialnetworkapi.entity.PostEntity;
import com.example.springsocialnetworkapi.repository.CommentRepository;
import com.example.springsocialnetworkapi.repository.PostRepository;
import com.example.springsocialnetworkapi.service.comment.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements ICommentService {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private CommentConverter commentConverter;

    @Override
    public CommentDto save(CommentDto commentDto) {
        CommentEntity commentEntity = new CommentEntity();
        if (commentDto.getId() != null) {
            CommentEntity oldComment = commentRepository.findById(commentDto.getId()).get();
            commentEntity = commentConverter.toEntity(commentDto, oldComment);
        } else {
            commentEntity = commentConverter.toEntity(commentDto);
        }
        PostEntity postEntity = postRepository.findById(commentDto.getPostID()).get();
        System.out.println(postEntity);
        commentEntity.setPost(postEntity);
        commentEntity = commentRepository.save(commentEntity);
        return commentConverter.toDto(commentEntity);
    }

    @Override
    public void delete(long[] ids) {
        for (long item : ids) {
            commentRepository.deleteById(item);
        }
    }

    @Override
    public List<CommentDto> getListComment() {
        List<CommentDto> result = new ArrayList<>();
        List<CommentEntity> comments = commentRepository.findAll();
        for (CommentEntity item : comments) {
            CommentDto commentDto = commentConverter.toDto(item);
            result.add(commentDto);
        }
        return result;
    }
}

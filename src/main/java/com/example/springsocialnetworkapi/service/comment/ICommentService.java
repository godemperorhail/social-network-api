package com.example.springsocialnetworkapi.service.comment;

import com.example.springsocialnetworkapi.dto.comment.CommentDto;
import com.example.springsocialnetworkapi.entity.CommentEntity;

import java.util.List;

public interface ICommentService {
    CommentDto save(CommentDto commentDto);
    void delete(long[] ids);
    List<CommentDto> getListComment();
}

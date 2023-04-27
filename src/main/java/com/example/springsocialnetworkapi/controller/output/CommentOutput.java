package com.example.springsocialnetworkapi.controller.output;

import com.example.springsocialnetworkapi.dto.comment.CommentDto;

import java.util.ArrayList;
import java.util.List;

public class CommentOutput {
    private List<CommentDto> listComment = new ArrayList<>();

    public List<CommentDto> getListComment() {
        return listComment;
    }

    public void setListComment(List<CommentDto> listComment) {
        this.listComment = listComment;
    }
}

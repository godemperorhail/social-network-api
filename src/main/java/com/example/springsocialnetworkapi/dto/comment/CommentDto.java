package com.example.springsocialnetworkapi.dto.comment;

import com.example.springsocialnetworkapi.dto.BaseDto;

public class CommentDto extends BaseDto {
    private String textComment;
    private String imageComment;
    private Long postID;

    public String getTextComment() {
        return textComment;
    }

    public void setTextComment(String textComment) {
        this.textComment = textComment;
    }

    public String getImageComment() {
        return imageComment;
    }

    public void setImageComment(String imageComment) {
        this.imageComment = imageComment;
    }

    public Long getPostID() {
        return postID;
    }

    public void setPostID(Long postID) {
        this.postID = postID;
    }
}

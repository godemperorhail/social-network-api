package com.example.springsocialnetworkapi.entity;

import javax.persistence.*;


@Entity
@Table(name = "Tbl_comment")
public class CommentEntity extends BaseEntity {
    @Column(name = "TEXT_COMMENT")
    private String textComment;
    @Column(name = "IMAGE_COMMENT")
    private String imageComment;
    @ManyToOne
    @JoinColumn(name = "post_id")
    private PostEntity post;


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

    public PostEntity getPost() {
        return post;
    }

    public void setPost(PostEntity post) {
        this.post = post;
    }


}

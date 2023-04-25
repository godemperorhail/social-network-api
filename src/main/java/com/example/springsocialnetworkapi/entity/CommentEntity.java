package com.example.springsocialnetworkapi.entity;

import javax.persistence.*;


@Entity
@Table(name = "Tbl_comment")
public class CommentEntity extends BaseEntity {
    @Column(name = "TEXT_COMMENT")
    private String text;
    @Column(name = "IMAGE_COMMENT")
    private String imageComment;
    @ManyToOne
    @JoinColumn(name = "post_id")
    private PostEntity post;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userComment;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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

    public UserEntity getUserComment() {
        return userComment;
    }

    public void setUserComment(UserEntity userComment) {
        this.userComment = userComment;
    }
}

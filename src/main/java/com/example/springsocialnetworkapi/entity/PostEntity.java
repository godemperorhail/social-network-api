package com.example.springsocialnetworkapi.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Tbl_post")
public class PostEntity extends BaseEntity {
    @Column(name = "CONTENT")
    private String content;
    @Column(name = "THUMBNAIL")
    private String thumbnail;
    @OneToMany(mappedBy = "postLiked")
    private List<UserEntity> userLikePost = new ArrayList<>();

    @Column(name = "LIKE_POST")
    private int postLike = userLikePost.size();

    @OneToMany(mappedBy = "post")
    private List<CommentEntity> comments = new ArrayList<>();

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public List<UserEntity> getUserLikePost() {
        return userLikePost;
    }

    public void setUserLikePost(List<UserEntity> userLikePost) {
        this.userLikePost = userLikePost;
    }

    public int getPostLike() {
        return postLike;
    }

    public void setPostLike(int postLike) {
        this.postLike = postLike;
    }


    public List<CommentEntity> getComments() {
        return comments;
    }

    public void setComments(List<CommentEntity> comments) {
        this.comments = comments;
    }
}

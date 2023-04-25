package com.example.springsocialnetworkapi.dto.post;

import com.example.springsocialnetworkapi.dto.BaseDto;
import com.example.springsocialnetworkapi.entity.UserEntity;

import javax.validation.constraints.NotBlank;

public class PostDto extends BaseDto {
    @NotBlank
    private String content;
    @NotBlank
    private String thumbnail;


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

}

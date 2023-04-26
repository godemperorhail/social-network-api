package com.example.springsocialnetworkapi.converter.post;

import com.example.springsocialnetworkapi.dto.post.PostDto;
import com.example.springsocialnetworkapi.entity.PostEntity;
import org.springframework.stereotype.Component;

@Component
public class PostConverter {
    public PostEntity toEntity(PostDto postDto) {
        PostEntity postEntity = new PostEntity();
        postEntity.setContent(postDto.getContent());
        postEntity.setThumbnail(postDto.getThumbnail());

        return postEntity;
    }

    public PostDto toDto(PostEntity entity) {
        PostDto dto = new PostDto();
        if (entity.getId() != null) {
            dto.setId(entity.getId());
        }
        dto.setContent(entity.getContent());
        dto.setThumbnail(entity.getThumbnail());
        dto.setCreatedBy(entity.getCreatedBy());
        dto.setCreatedDate(entity.getCreatedDate());
        dto.setModifiedBy(entity.getModifiedBy());
        dto.setModifiedDate(entity.getModifiedDate());
        return dto;
    }

    public PostEntity toEntity(PostDto dto, PostEntity entity) {
        entity.setContent(dto.getContent());
        entity.setThumbnail(dto.getThumbnail());
        return entity;
    }

}

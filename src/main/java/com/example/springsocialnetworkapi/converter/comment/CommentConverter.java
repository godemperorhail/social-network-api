package com.example.springsocialnetworkapi.converter.comment;

import com.example.springsocialnetworkapi.dto.comment.CommentDto;
import com.example.springsocialnetworkapi.entity.CommentEntity;
import org.springframework.stereotype.Component;

@Component
public class CommentConverter {
    public CommentEntity toEntity(CommentDto dto){
        CommentEntity entity =new CommentEntity();
        entity.setTextComment(dto.getTextComment());
        entity.setImageComment(dto.getImageComment());
        return entity;
    }
    public CommentDto toDto(CommentEntity entity){
        CommentDto dto =new CommentDto();
        if (entity.getId() != null) {
            dto.setId(entity.getId());
        }
        dto.setCreatedDate(entity.getCreatedDate());
        dto.setCreatedBy(entity.getCreatedBy());
        dto.setModifiedDate(entity.getModifiedDate());
        dto.setModifiedBy(entity.getModifiedBy());
        dto.setTextComment(entity.getTextComment());
        dto.setImageComment(entity.getImageComment());
        dto.setPostID(entity.getPost().getId());
        return dto;
    }
    public CommentEntity toEntity(CommentDto dto, CommentEntity entity) {
        entity.setTextComment(dto.getTextComment());
        entity.setImageComment(dto.getImageComment());
        return entity;
    }
}

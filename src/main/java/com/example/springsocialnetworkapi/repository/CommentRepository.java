package com.example.springsocialnetworkapi.repository;

import com.example.springsocialnetworkapi.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {

}

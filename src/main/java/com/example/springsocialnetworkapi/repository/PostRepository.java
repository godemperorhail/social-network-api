package com.example.springsocialnetworkapi.repository;

import com.example.springsocialnetworkapi.entity.PostEntity;
import com.example.springsocialnetworkapi.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostRepository extends JpaRepository<PostEntity, Long> {

}

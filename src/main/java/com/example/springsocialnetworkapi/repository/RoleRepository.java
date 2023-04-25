package com.example.springsocialnetworkapi.repository;

import com.example.springsocialnetworkapi.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
    Optional<RoleEntity> findOneByRoleCode(String roleCode);
}

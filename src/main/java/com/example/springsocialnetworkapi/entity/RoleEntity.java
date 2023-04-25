package com.example.springsocialnetworkapi.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Tbl_role")
public class RoleEntity extends BaseEntity {

    @Column(name = "ROLE_CODE", length = 30, nullable = false)
    private String roleCode;
    @Column(name = "ROLE_NAME", length = 30, nullable = false)
    private String roleName;
    @ManyToMany(mappedBy = "roles")
    private List<UserEntity> users = new ArrayList<>();


    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(List<UserEntity> users) {
        this.users = users;
    }
}

package com.example.springsocialnetworkapi.entity;


import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Tbl_user")
public class UserEntity extends BaseEntity {

    @Column(name = "USERNAME", length = 36, nullable = false)
    private String username;
    @Column(name = "ENCRYPTED_PASSWORD", length = 128, nullable = false)
    private String encrytedPassword;
    @Column(name = "FIRSTNAME_USER", length = 36, nullable = false)
    private String firstName;
    @Column(name = "LASTNAME_USER", length = 36, nullable = false)
    private String lastName;
    @Column(name = "EMAIL_USER", length = 36, nullable = false)
    @Email
    private String email;
    @Column(name = "BIO_USER", length = 256)
    private String bio;
    @Column(name = "IMAGE_USER")
    private String avatar;
    @Column(name = "Enabled", length = 1, nullable = false)
    private boolean enabled;

    @ManyToMany
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<RoleEntity> roles = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "post_id")
    private PostEntity postLiked;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEncrytedPassword() {
        return encrytedPassword;
    }

    public void setEncrytedPassword(String encrytedPassword) {
        this.encrytedPassword = encrytedPassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public PostEntity getPostLiked() {
        return postLiked;
    }

    public void setPostLiked(PostEntity postLiked) {
        this.postLiked = postLiked;
    }

    public List<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleEntity> roles) {
        this.roles = roles;
    }

}

package com.study.uploadfiles.model.dto;

import java.io.Serializable;
import java.util.Objects;

public class UserDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private String avatar;

    private String createAt;

    private String updateAt;

    public UserDTO() {
    }

    public UserDTO(Long id, String name, String avatar, String createAt, String updateAt) {
        this.id = id;
        this.name = name;
        this.avatar = avatar;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getCreateAt() {
        return this.createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public String getUpdateAt() {
        return this.updateAt;
    }

    public void setUpdateAt(String updateAt) {
        this.updateAt = updateAt;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof UserDTO)) {
            return false;
        }
        UserDTO userDTO = (UserDTO) o;
        return Objects.equals(id, userDTO.id) && Objects.equals(name, userDTO.name)
                && Objects.equals(avatar, userDTO.avatar) && Objects.equals(createAt, userDTO.createAt)
                && Objects.equals(updateAt, userDTO.updateAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, avatar, createAt, updateAt);
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", name='" + getName() + "'" + ", avatar='" + getAvatar() + "'"
                + ", createAt='" + getCreateAt() + "'" + ", updateAt='" + getUpdateAt() + "'" + "}";
    }

}

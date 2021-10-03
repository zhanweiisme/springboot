package com.lovezhan.bean;

import java.util.List;

public class AdminUser {
    private Integer id;

    private String username;

    private String password;

    private String role;

    private String nickname;

    private String avatar;
    
    private List<String> roles;

    public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

	@Override
	public String toString() {
		return "AdminUser [id=" + id + ", username=" + username + ", password=" + password + ", role=" + role
				+ ", nickname=" + nickname + ", avatar=" + avatar + "]";
	}
    
    
}
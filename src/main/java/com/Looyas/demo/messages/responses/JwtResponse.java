package com.looyas.demo.messages.responses;

import com.looyas.demo.models.Role;

import java.util.List;
import java.util.Set;

//JwtResponse.java is returned by SpringBoot server after successful authentication, it contains 2 parts:
//JWT Token
//Schema Type of Token
public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private String username;
    private Set<Role> authorities ;

    public JwtResponse(String token, String username, Set<Role> authorities) {
        this.token = token;
        this.username = username;
        this.authorities = authorities;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<Role> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Role> authorities) {
        this.authorities = authorities;
    }
}

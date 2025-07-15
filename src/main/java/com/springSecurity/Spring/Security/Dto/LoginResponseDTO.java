package com.springSecurity.Spring.Security.Dto;

public class LoginResponseDTO {
    String name;
    String email;
    String role;
    String token;

    public LoginResponseDTO() {

    }

    public LoginResponseDTO(Integer userid, String name, String email, String password, String role, String token) {
        this.name = name;
        this.email = email;
        this.role = role;
        this.token = token;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public String getToken() {
        return token;
    }

}

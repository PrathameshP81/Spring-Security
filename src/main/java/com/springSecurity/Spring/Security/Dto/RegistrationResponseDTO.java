package com.springSecurity.Spring.Security.Dto;

public class RegistrationResponseDTO {
    String name;
    String email;
    String role;

    public RegistrationResponseDTO() {
    }

    public RegistrationResponseDTO(Integer userid, String name, String email, String password, String role,
            String token) {
        this.name = name;
        this.email = email;
        this.role = role;

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

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

}

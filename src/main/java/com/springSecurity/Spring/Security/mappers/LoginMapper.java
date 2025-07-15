package com.springSecurity.Spring.Security.mappers;

import com.springSecurity.Spring.Security.Dto.LoginResponseDTO;
import com.springSecurity.Spring.Security.model.User;

public class LoginMapper {

    public static LoginResponseDTO toDTO(User user, String token) {

        if (user == null && token != null)
            return null;

        LoginResponseDTO dto = new LoginResponseDTO();
        dto.setEmail(user.getEmail());
        dto.setName(user.getName());
        dto.setRole(user.getRole());
        dto.setToken(token);
        return dto;
    }
}

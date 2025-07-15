package com.springSecurity.Spring.Security.mappers;

import com.springSecurity.Spring.Security.Dto.RegistrationResponseDTO;
import com.springSecurity.Spring.Security.model.User;

public class RegisterMapper {

    public static RegistrationResponseDTO toDTO(User user) {

        if (user == null)
            return null;

        RegistrationResponseDTO dto = new RegistrationResponseDTO();
        dto.setEmail(user.getEmail());
        dto.setName(user.getName());
        dto.setRole(user.getRole());
        return dto;
    }
}

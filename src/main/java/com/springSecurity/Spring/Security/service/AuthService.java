package com.springSecurity.Spring.Security.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.springSecurity.Spring.Security.Dto.LoginRequestDTO;
import com.springSecurity.Spring.Security.Dto.LoginResponseDTO;
import com.springSecurity.Spring.Security.Dto.RegistrationResponseDTO;
import com.springSecurity.Spring.Security.Dto.ResponseDTO;
import com.springSecurity.Spring.Security.ExceptionHandler.authException;
import com.springSecurity.Spring.Security.auth.JwtUtils;
import com.springSecurity.Spring.Security.mappers.LoginMapper;
import com.springSecurity.Spring.Security.mappers.RegisterMapper;
import com.springSecurity.Spring.Security.model.User;
import com.springSecurity.Spring.Security.repo.UserRepo;

@Service
public class AuthService {

    UserRepo userRepo;
    PasswordEncoder passwordEncoder;
    AuthenticationManager authenticationManager;
    JwtUtils jwtUtils;

    public AuthService(UserRepo userRepo, PasswordEncoder passwordEncoder,
            AuthenticationManager authenticationManager, JwtUtils jwtUtils) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
    }

    public ResponseEntity<ResponseDTO<RegistrationResponseDTO>> register(User user) {

        ResponseDTO<RegistrationResponseDTO> responseDTO;

        try {
            if (user == null)
                throw new authException("Please provide valid user details");

            User isUserExist = userRepo.findByEmail(user.getEmail());

            if (isUserExist == null) {
                user.setPassword(passwordEncoder.encode(user.getPassword()));
                User savedUser = userRepo.save(user);

                RegistrationResponseDTO registrationResponseDTO = RegisterMapper.toDTO(savedUser);

                responseDTO = new ResponseDTO<>("User Register Successfully", HttpStatus.OK.value(),
                        registrationResponseDTO);

                return new ResponseEntity<>(responseDTO, HttpStatus.OK);
            } else {
                throw new authException("User Already Exist ");
            }

        } catch (Exception e) {
            throw new authException("Failed to Register User " + e.getMessage());
        }
    }

    public ResponseEntity<ResponseDTO<LoginResponseDTO>> login(LoginRequestDTO request) {
        ResponseDTO<LoginResponseDTO> responseDTO;

        try {

            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(), request.getPassword()));

            SecurityContextHolder.getContext().setAuthentication(authentication);

            String token = jwtUtils.generateToken(request.getEmail());
            User user = userRepo.findByEmail(request.getEmail());

            LoginResponseDTO loginResponseDTO = LoginMapper.toDTO(user, token);

            responseDTO = new ResponseDTO<>("User Logged In Successfully", HttpStatus.OK.value(), loginResponseDTO);
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);

        } catch (AuthenticationException e) {
            throw new authException("Failed to Login User " + e.getMessage());
        }
    }
}

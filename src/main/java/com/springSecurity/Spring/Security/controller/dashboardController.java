package com.springSecurity.Spring.Security.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.springSecurity.Spring.Security.model.User;

@RestController
@RequestMapping("/admin/dashboard")
public class dashboardController {

    @GetMapping()
    public ResponseEntity<String> Dashboard() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null && auth.isAuthenticated() && auth.getPrincipal() instanceof User) {
            User user = (User) auth.getPrincipal();
            System.out.println(user);
            return ResponseEntity.ok("Welcome To Dashboard Controller " + user.getUsername());
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized");
    }
}

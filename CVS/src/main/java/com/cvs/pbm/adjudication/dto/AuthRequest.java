package com.cvs.pbm.adjudication.dto;

import jakarta.validation.constraints.NotBlank;

public class AuthRequest {

    // Private fields to store the authentication request details
    @NotBlank(message = "Username is mandatory")
    private String username;

    @NotBlank(message = "Password is required")
    private String password;

    
    public AuthRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // --- Getter Methods ---

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    // --- Setter Methods ---

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}


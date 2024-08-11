package com.example.newtodoapp;

// import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

public class User {

    private String username;
    private String email;
    private String password;

    // Getters
    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    // Setters
    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User [username=" + username + ", email=" + email + ", password=" + password + "]";
    }

    // public static UserDetailsServiceAutoConfiguration WithDefaultPasswordEncoder() {
    
    //     throw new UnsupportedOperationException("Unimplemented method 'WithDefaultPasswordEncoder'");
    // }


}


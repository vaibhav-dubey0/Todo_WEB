package com.example.newtodoapp;

import org.springframework.stereotype.Service;

@Service
public class Authenticate {
    public boolean check(String username, String email, String password) {
        boolean isValidName = username.equalsIgnoreCase("Vaibhav");
        boolean isValidEmail = email.equalsIgnoreCase("dubeyvaibhav@gmail.com");
        boolean isValidPass = password.equalsIgnoreCase("Vaibhav@123");

        return isValidName && isValidEmail && isValidPass;
    }
}

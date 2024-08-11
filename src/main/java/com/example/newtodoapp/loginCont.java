package com.example.newtodoapp;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class loginCont {

     @GetMapping("/")
    public String homePage(ModelMap model) {
        model.addAttribute("name",getLoggedinUsername());
        return "index";
    }

   
    private String getLoggedinUsername() {
 
        Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
        
    }
    
}

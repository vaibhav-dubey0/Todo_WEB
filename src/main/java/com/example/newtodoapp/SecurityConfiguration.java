package com.example.newtodoapp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.function.Function;

import static org.springframework.security.config.Customizer.withDefaults;
@Configuration
public class SecurityConfiguration {
    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
    	
    	
		
    	UserDetails user = createNewUser("Vaibhav Dubey", "Vaibhav@123");
        UserDetails user1 = createNewUser("Nikhil Dubey", "Nikhil@123");
        UserDetails user2 = createNewUser("Prince Dubey", "Prince@123");
        return new InMemoryUserDetailsManager(user,user1,user2);
    }

    private UserDetails createNewUser(String username, String password) {
        Function<String, String> encoder = input -> passwordEncoder().encode(input);
        UserDetails user = User.builder().passwordEncoder(
    			encoder
    			)
            .username(username)
            .password(password)
            .roles("USER")
            .build();
        return user;
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    } 

   
    @SuppressWarnings("removal")
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        http.authorizeHttpRequests(
            auth -> auth.anyRequest().authenticated());
            http.formLogin(withDefaults());
        http.csrf(csrf -> csrf.disable());
        http.headers(headers -> headers.frameOptions().disable());  
                
            return http.build();
    }
}





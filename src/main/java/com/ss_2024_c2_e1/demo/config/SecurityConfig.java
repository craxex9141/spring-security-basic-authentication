package com.ss_2024_c2_e1.demo.config;

import com.ss_2024_c2_e1.demo.repository.UserRepository;
import com.ss_2024_c2_e1.demo.service.JpaUserDetailService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
@AllArgsConstructor
@Configuration
public class SecurityConfig {

    private final UserRepository userRepository;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
//    @Bean
//    public UserDetailsService userDetailsService(){
//        return new JpaUserDetailService(userRepository);
//    }

}

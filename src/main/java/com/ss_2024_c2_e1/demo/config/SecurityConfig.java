package com.ss_2024_c2_e1.demo.config;

import com.ss_2024_c2_e1.demo.config.filter.ApiKeyFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class SecurityConfig {

    @Value("${the.secret}")
    private String key;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http_security) throws Exception {
        return  http_security.httpBasic()
                .and()
                .addFilterBefore(new ApiKeyFilter(key), BasicAuthenticationFilter.class)
                .authorizeRequests().anyRequest().authenticated()
                //.and().authenticationManager()  //or by adding a bean of type AuthenticationMAnager
                //.and().authenticationProvider() //it doesn't ovverride  the AuthenticationProvider , it adds one more to the collection
                .and().build();
    }
}

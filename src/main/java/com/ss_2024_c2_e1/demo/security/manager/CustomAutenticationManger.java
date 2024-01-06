package com.ss_2024_c2_e1.demo.security.manager;

import com.ss_2024_c2_e1.demo.security.provider.CustomAuthenticationProvider;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CustomAutenticationManger implements AuthenticationManager {

    private final CustomAuthenticationProvider provider;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        if (provider.supports(authentication.getClass())){
            return provider.authenticate(authentication);
        }

        throw new BadCredentialsException("Oh No ! ");
    }
}

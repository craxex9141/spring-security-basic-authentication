package com.ss_2024_c2_e1.demo.config.manager;

import com.ss_2024_c2_e1.demo.config.provider.ApiKeyProvider;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

@AllArgsConstructor
public class CustomAuthenticationManger implements AuthenticationManager {


    private final String key;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        var provider = new ApiKeyProvider(key);
        if (provider.supports(authentication.getClass())){
            return provider.authenticate(authentication);
        }

        return authentication; //return non authenticated Authentication which further would be thrown as BadCredentialException
    }
}

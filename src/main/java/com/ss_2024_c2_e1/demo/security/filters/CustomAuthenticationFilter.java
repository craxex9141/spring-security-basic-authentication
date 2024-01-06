package com.ss_2024_c2_e1.demo.security.filters;

import com.ss_2024_c2_e1.demo.security.authentication.CustomAuthentication;
import com.ss_2024_c2_e1.demo.security.manager.CustomAutenticationManger;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;


@Component
@AllArgsConstructor
public class CustomAuthenticationFilter extends OncePerRequestFilter {

    private final CustomAutenticationManger customAutenticationManger;
    @Override
    protected void doFilterInternal(HttpServletRequest request
            , HttpServletResponse response
            , FilterChain filterChain) throws ServletException, IOException {

        //1. create an authentication object which is not yet authenticated
        //2. delegate the authentication object to manager
        //3. get back the authentication from manager
        //4. if the object is authenticated then send request to the next filter in chain


        String key = String.valueOf(request.getHeader("key"));
        CustomAuthentication ca = new CustomAuthentication(false,key);

        var a = customAutenticationManger.authenticate(ca);

        if (a.isAuthenticated()){
            SecurityContextHolder.getContext().setAuthentication(a);
            filterChain.doFilter(request,response);//only when authentication worked

        }


    }
}

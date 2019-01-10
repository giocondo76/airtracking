package com.nc.service.impl;

import com.nc.models.CustomUserDetails;
import com.nc.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;

public class SecurityServiceImpl implements SecurityService {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    //получаем имя авториз пользователя
    @Override
    public String findLoggedInLogin() {
        Object customUserDetails = SecurityContextHolder.getContext().getAuthentication().getDetails();
        if (customUserDetails instanceof CustomUserDetails){
            return ((CustomUserDetails) customUserDetails).getUsername();
        }

        return null;
    }

    @Override
    public void autoLogin(String login, String password) {
        CustomUserDetails userDetails = (CustomUserDetails) userDetailsService.loadUserByUsername(login);
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());

        authenticationManager.authenticate(authenticationToken);

        if(authenticationToken.isAuthenticated()){
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }
    }

}

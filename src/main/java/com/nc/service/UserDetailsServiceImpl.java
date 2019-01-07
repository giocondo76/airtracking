package com.nc.service;

import com.nc.models.CustomUserDetails;
import com.nc.models.User;
import com.nc.repository.RoleRepository;
import com.nc.repository.UserRepository;
import com.sun.security.auth.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public CustomUserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException(email);
        }
        GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole().getName());
        CustomUserDetails customUserDetails = new CustomUserDetails(user.getName(),
                user.getPassword(), Arrays.asList(authority));
//        CustomUserDetails customUserDetail=new CustomUserDetail();
//        customUserDetail.setUser(domainUser);
//        customUserDetail.setAuthorities(authorities);
        return customUserDetails;
//    }
    }
}
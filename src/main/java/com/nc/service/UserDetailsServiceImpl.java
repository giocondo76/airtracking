package com.nc.service;

import com.nc.models.Role;
import com.nc.models.User;
import com.nc.repository.RoleRepository;
import com.nc.repository.UserRepository;
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
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {



    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        email = user.getEmail();
        if(email == null){
            throw new UsernameNotFoundException("User not authorized.");
        }
        GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole().getName());
        UserDetails userDetails = (UserDetails)new User(user.getName(),
                user.getPassword(), Arrays.asList(authority));
        return userDetails;
    }
}

package com.example.demo.security;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.UserBO;
import com.example.demo.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Locale;

/**
 * lấy thông tin user theo username khi đăng nhập
 */
@Component("userDetailService")
public class DomainUserDetailsService implements UserDetailsService {
    private final Logger log = LoggerFactory.getLogger(DomainUserDetailsService.class);

    private final UserRepository userRepository;


    public DomainUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(final String login) {
        log.debug("Authenticating  {}", login);
        String lowercaseLogin = login.toLowerCase(Locale.ENGLISH);
        return userRepository.getUserByUsername(lowercaseLogin).map(user -> createSpringSecurityUser(lowercaseLogin, user))//tìm thấy tạo ra User
                .orElseThrow(() -> new UsernameNotFoundException("User " + lowercaseLogin + " was not found in the database"));
    }

    //tạo SercurityUser: role,username,password
    private User createSpringSecurityUser(String lowercaseLogin, UserBO user) {
        String role = user.getRole();
        GrantedAuthority authority = new SimpleGrantedAuthority(role);
        return new User(user.getUsername(), user.getPasswordHash(), Arrays.asList(authority));
    }
}

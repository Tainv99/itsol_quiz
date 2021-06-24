package com.example.demo.controller;

import com.example.demo.dto.LoginDTO;
import com.example.demo.security.JWTFilter;
import com.example.demo.security.TokenProvider;
//import com.example.demo.security.UserLoad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/v1")
public class LoginRest {
    @Autowired
    private TokenProvider tokenProvider;
    @Autowired
    private AuthenticationManagerBuilder authenticationManagerBuilder;

    @PostMapping("/login")
    public ResponseEntity<JWTToken> authorize(@Valid @RequestBody LoginDTO loginDTO) {

        try {
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginDTO.getUsername(), loginDTO.getPassword());
            Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = tokenProvider.createToken(authentication);
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add(JWTFilter.AUTHORIZATION_HEADER, "Bearer " + jwt);
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
//            UserLoad us = authentication.getPrincipal();
            return new ResponseEntity<JWTToken>(new JWTToken(jwt, userDetails.getUsername()), httpHeaders, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(new JWTToken(), HttpStatus.UNAUTHORIZED);
        }
    }

    static class JWTToken {

        private String idToken;
        private String role;
        private String username;
        private String email;
        public JWTToken() {
        }

//        public JWTToken(String idToken) {
//            this.idToken = idToken;
//        }

        public JWTToken(String idToken, String username) {
            this.idToken = idToken;
            this.username = username;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getIdToken() {
            return idToken;
        }

        public void setIdToken(String idToken) {
            this.idToken = idToken;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }
    }
}

package com.example.authentication.api;

import com.example.authentication.dto.AuthDTO;
import com.example.authentication.dto.TokenKey;
import com.example.authentication.service.TokenService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/token")
public class TokenAPI {

    @Autowired 
    TokenService tokenService;


    @GetMapping("/")
    public ResponseEntity<AuthDTO> defaultToken() throws Exception {
        return new ResponseEntity<AuthDTO>(new AuthDTO(tokenService.defaultToken(), true), HttpStatus.OK);
    }

    @GetMapping("/tokenkey")
    public ResponseEntity<TokenKey> tokenKey() throws Exception {
        return new ResponseEntity<TokenKey>(new TokenKey(), HttpStatus.OK);
    }

}
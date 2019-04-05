package com.example.authentication.dto;

import java.util.ArrayList;
import java.util.List;

public class TokenKey {
    private List<TokenDTO> keys;

    public TokenKey(){
        this.keys = new ArrayList<>();
        this.keys.add(new TokenDTO());
    }

    public List<TokenDTO> getKeys(){
        return this.keys;
    }
}

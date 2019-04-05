package com.example.authentication.dto;

public class AuthDTO {
    private String tokenId;

    private boolean valid;

    public AuthDTO(String tokenId, boolean valid){
        this.tokenId = tokenId;
        this.valid = valid;
    }

    public String getTokenId(){
        return this.tokenId;
    }

    public boolean isValid(){
        return this.valid;
    }
}
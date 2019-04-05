package com.example.authentication.service;

import atg.taglib.json.util.JSONObject;

public interface TokenService {

    public String defaultToken()  throws Exception;

    public String generateToken(JSONObject tokenJson, Long tokenExpiry)  throws Exception;

    public String getTokenData(String tokenId)  throws Exception;
}
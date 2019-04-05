package com.example.authentication.service;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.DatatypeConverter;

import org.springframework.stereotype.Service;

import atg.taglib.json.util.JSONObject;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenServiceImpl implements TokenService {

    private String privateKey = "MIIBUwIBADANBgkqhkiG9w0BAQEFAASCAT0wggE5AgEAAkEAjmL9Qvdsrf9kccVLO8QpXuKamRhOTERVHoK9sr5EyHCNMYmkQjE9cLCkNs/VUg1KAIBQBm9yatmdekPKvLxprQIDAQABAkA62YERv4/kro0GVOQOdLogpIn/QsOB1DBWJvVevjNRoEzexLEI8Ey3IJm7+7KqJV+ZIy1f27/18RQQ76yAwfllAiEA0FgnNm5xnwIcmcE9dU1Rh599iYeTGAtb5eEgEqe3R38CIQCu9JuLHo9HtvhdZV5ekIOHMRij5R6k7PaRQVeI77GE0wIgEgC8CrEKcmH9VK/k/qDavaxjbaHgbQB2RWvpmJMTfEMCIAe94zQgwg5WVl8roSVmF6vfzEtUVCrQIYkD7y+sC5rpAiBSzIzLg+T8bVjO4w9r0F1zQ5pSdrE22bkyzBVfs7P9lg==";
    private String publicKey = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAI5i/UL3bK3/ZHHFSzvEKV7impkYTkxEVR6CvbK+RMhwjTGJpEIxPXCwpDbP1VINSgCAUAZvcmrZnXpDyry8aa0CAwEAAQ==";

    @Override
    public String defaultToken()  throws Exception{
        
        JSONObject tokenData = new JSONObject();
        tokenData.put("userid", "0987654321");
        tokenData.put("name", "Ketan Gote");

        String token = generateToken(tokenData, Long.valueOf("180000"));
        return token;
    }

    @Override
    public String generateToken(JSONObject tokenJson, Long tokenExpiry) throws Exception {

        Map<String, Object> claims = new HashMap<>();
        claims.put("user", "cope");
        return Jwts.builder().setClaims(claims)
                .setIssuer("ketan.gote@metamagic.in").setAudience("metamagic").setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + tokenExpiry))
                .signWith(SignatureAlgorithm.HS512, privateKey).compact();
    }

    @Override
    public String getTokenData(String tokenId) throws Exception {
        return Jwts.parser()
                    .setSigningKey(DatatypeConverter.parseBase64Binary(privateKey))
                    .require("user", "cope")
                    .parseClaimsJws(tokenId)
                    .getBody()
                    .toString();
    }

    public static void main(String[] args) throws Exception {
        TokenServiceImpl ts = new TokenServiceImpl();
        JSONObject tokenData = new JSONObject();
        tokenData.put("userid", "0987654321");
        tokenData.put("name", "Ketan Gote");

        String token = ts.generateToken(tokenData, Long.valueOf("180000"));
        System.out.println("TOKEN GENERATED --- > \n" + token);
        String tokenD = ts.getTokenData(token);
        System.out.println("TOKEN DATA --- > \n" + tokenD);

    }

    private static void generateKeys() {
        try {
            
            KeyPairGenerator keyGenerator = KeyPairGenerator.getInstance("RSA");
            keyGenerator.initialize(512);

            KeyPair kp = keyGenerator.genKeyPair();
            PublicKey publicKey = (PublicKey) kp.getPublic();
            PrivateKey privateKey = (PrivateKey) kp.getPrivate();

            String encodedPublicKey = Base64.getEncoder().encodeToString(publicKey.getEncoded());
            System.out.println("Public Key:");
            System.out.println(convertToPublicKey(encodedPublicKey));

            String encodedPrivateKey = Base64.getEncoder().encodeToString(privateKey.getEncoded());
            System.out.println("Private Key:");
            System.out.println(convertToPublicKey(encodedPrivateKey));
        } catch (Exception e) {

        }

    }

    private static String convertToPublicKey(String key) {
        StringBuilder result = new StringBuilder();
        result.append("-----BEGIN  KEY-----\n");
        result.append(key);
        result.append("\n-----END  KEY-----");
        return result.toString();
    }
}
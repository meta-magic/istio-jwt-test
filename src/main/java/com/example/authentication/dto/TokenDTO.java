package com.example.authentication.dto;

public class TokenDTO {
    private String kty,n, e, kid;

    public TokenDTO(){
        this.kty = "RSA";
        this.n = "eyJhbGciOiJIUzUxMiJ9.eyJhdWQiOiJtZXRhbWFnaWMiLCJpc3MiOiJrZXRhbi5nb3RlQG1ldGFtYWdpYy5pbiIsImV4cCI6MTU1NDQ2MzcwMywidXNlciI6ImNvcGUiLCJpYXQiOjE1NTQ0NjM1MjN9.bvw6O99-2WbF6d78qf4WZNXALQkQ6dbgfsAzBYesxZLLdJR5f5hgXUkD-cDD9NDk0SxkX8TmsSnQJDhlYUXbug";
        this.e = "AQAB";
        this.kid = "MKEY";
    }

    /**
     * @return the kty
     */
    public String getKty() {
        return kty;
    }
 
    /**
     * @return the n
     */
    public String getN() {
        return n;
    }
 
    /**
     * @return the e
     */
    public String getE() {
        return e;
    }

    

    /**
     * @return the kid
     */
    public String getKid() {
        return kid;
    }

     


}

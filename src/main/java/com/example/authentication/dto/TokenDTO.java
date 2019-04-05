package com.example.authentication.dto;

public class TokenDTO {
    private String kty,n, e, kid;

    public TokenDTO(){
        this.kty = "RSA";
        this.n = "MIIBUwIBADANBgkqhkiG9w0BAQEFAASCAT0wggE5AgEAAkEAjmL9Qvdsrf9kccVLO8QpXuKamRhOTERVHoK9sr5EyHCNMYmkQjE9cLCkNs/VUg1KAIBQBm9yatmdekPKvLxprQIDAQABAkA62YERv4/kro0GVOQOdLogpIn/QsOB1DBWJvVevjNRoEzexLEI8Ey3IJm7+7KqJV+ZIy1f27/18RQQ76yAwfllAiEA0FgnNm5xnwIcmcE9dU1Rh599iYeTGAtb5eEgEqe3R38CIQCu9JuLHo9HtvhdZV5ekIOHMRij5R6k7PaRQVeI77GE0wIgEgC8CrEKcmH9VK/k/qDavaxjbaHgbQB2RWvpmJMTfEMCIAe94zQgwg5WVl8roSVmF6vfzEtUVCrQIYkD7y+sC5rpAiBSzIzLg+T8bVjO4w9r0F1zQ5pSdrE22bkyzBVfs7P9lg==";
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

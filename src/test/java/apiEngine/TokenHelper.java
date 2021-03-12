package apiEngine;

public class TokenHelper {
    private String token;
    private static TokenHelper instance = null;

    private TokenHelper() {
    }

    public static TokenHelper getInstance() {
        if (instance == null) {
            instance = new TokenHelper();
        }
        return instance;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

package apiEngine;

public class TokenHelper {
    private static String token;

    public static String getToken() {
        return token;
    }

    public static void setToken(String token) {
        TokenHelper.token = token;
    }
}

package apiEngine.models.response;

import lombok.Data;

@Data
public class Token {
    public String access_token;
    public String refresh_token;
    public String expires_in;
    public String token_type;
}

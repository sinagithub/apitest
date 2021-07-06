package apiEngine.models.requests.YsUserService;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "userData",
        "ysRequest"
})

public class RegisterRequest {

    @JsonProperty("userData")
    private UserData userData;
    @JsonProperty("ysRequest")
    private YsRequest ysRequest;

    /**
     * No args constructor for use in serialization
     *
     */
    public RegisterRequest() {
    }

    /**
     *
     * @param ysRequest
     * @param userData
     */
    public RegisterRequest(UserData userData, YsRequest ysRequest) {
        super();
        this.userData = userData;
        this.ysRequest = ysRequest;
    }

    @JsonProperty("userData")
    public UserData getUserData() {
        return userData;
    }

    @JsonProperty("userData")
    public void setUserData(UserData userData) {
        this.userData = userData;
    }

    @JsonProperty("ysRequest")
    public YsRequest getYsRequest() {
        return ysRequest;
    }

    @JsonProperty("ysRequest")
    public void setYsRequest(YsRequest ysRequest) {
        this.ysRequest = ysRequest;
    }

}
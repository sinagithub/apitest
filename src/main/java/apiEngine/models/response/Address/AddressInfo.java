package apiEngine.models.response.Address;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Code",
        "Message",
        "ShowToUser"
})

public class AddressInfo {

    @JsonProperty("Code")
    private Integer code;
    @JsonProperty("Message")
    private String message;
    @JsonProperty("ShowToUser")
    private Boolean showToUser;

    @JsonProperty("Code")
    public Integer getCode() {
        return code;
    }

    @JsonProperty("Code")
    public void setCode(Integer code) {
        this.code = code;
    }

    @JsonProperty("Message")
    public String getMessage() {
        return message;
    }

    @JsonProperty("Message")
    public void setMessage(String message) {
        this.message = message;
    }

    @JsonProperty("ShowToUser")
    public Boolean getShowToUser() {
        return showToUser;
    }

    @JsonProperty("ShowToUser")
    public void setShowToUser(Boolean showToUser) {
        this.showToUser = showToUser;
    }
}

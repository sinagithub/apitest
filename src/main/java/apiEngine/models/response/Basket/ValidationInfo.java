package apiEngine.models.response.Basket;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
        "IsValid",
        "UserFriendlyMessages"
})

public class ValidationInfo {

    @JsonProperty("IsValid")
    private Boolean isValid;
    @JsonProperty("UserFriendlyMessages")
    private List<String> userFriendlyMessages = null;

    @JsonProperty("IsValid")
    public Boolean getIsValid() {
        return isValid;
    }

    @JsonProperty("IsValid")
    public void setIsValid(Boolean isValid) {
        this.isValid = isValid;
    }

    @JsonProperty("UserFriendlyMessages")
    public List<String> getUserFriendlyMessages() {
        return userFriendlyMessages;
    }

    @JsonProperty("UserFriendlyMessages")
    public void setUserFriendlyMessages(List<String> userFriendlyMessages) {
        this.userFriendlyMessages = userFriendlyMessages;
    }

}

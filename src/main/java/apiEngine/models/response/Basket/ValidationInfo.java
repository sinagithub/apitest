package apiEngine.models.response.Basket;

import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "IsValid",
        "RequiredAmountForDelivery",
        "UserFriendlyMessages"
})
@Generated("jsonschema2pojo")
public class ValidationInfo {

    @JsonProperty("IsValid")
    private Boolean isValid;
    @JsonProperty("RequiredAmountForDelivery")
    private String requiredAmountForDelivery;
    @JsonProperty("UserFriendlyMessages")
    private List<String> userFriendlyMessages = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public ValidationInfo() {
    }

    /**
     *
     * @param userFriendlyMessages
     * @param isValid
     * @param requiredAmountForDelivery
     */
    public ValidationInfo(Boolean isValid, String requiredAmountForDelivery, List<String> userFriendlyMessages) {
        super();
        this.isValid = isValid;
        this.requiredAmountForDelivery = requiredAmountForDelivery;
        this.userFriendlyMessages = userFriendlyMessages;
    }

    @JsonProperty("IsValid")
    public Boolean getIsValid() {
        return isValid;
    }

    @JsonProperty("IsValid")
    public void setIsValid(Boolean isValid) {
        this.isValid = isValid;
    }

    @JsonProperty("RequiredAmountForDelivery")
    public String getRequiredAmountForDelivery() {
        return requiredAmountForDelivery;
    }

    @JsonProperty("RequiredAmountForDelivery")
    public void setRequiredAmountForDelivery(String requiredAmountForDelivery) {
        this.requiredAmountForDelivery = requiredAmountForDelivery;
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
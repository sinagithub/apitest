package apiEngine.models.response.Payment;

import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "CreditCards",
        "AskCVV",
        "ResponseCode",
        "Success",
        "HasSavedCreditCard"
})
@Generated("jsonschema2pojo")
public class UserCardData {

    @JsonProperty("CreditCards")
    private List<CreditCard> creditCards = null;
    @JsonProperty("AskCVV")
    private Boolean askCVV;
    @JsonProperty("ResponseCode")
    private String responseCode;
    @JsonProperty("Success")
    private Boolean success;
    @JsonProperty("HasSavedCreditCard")
    private Boolean hasSavedCreditCard;

    @JsonProperty("CreditCards")
    public List<CreditCard> getCreditCards() {
        return creditCards;
    }

    @JsonProperty("CreditCards")
    public void setCreditCards(List<CreditCard> creditCards) {
        this.creditCards = creditCards;
    }

    @JsonProperty("AskCVV")
    public Boolean getAskCVV() {
        return askCVV;
    }

    @JsonProperty("AskCVV")
    public void setAskCVV(Boolean askCVV) {
        this.askCVV = askCVV;
    }

    @JsonProperty("ResponseCode")
    public String getResponseCode() {
        return responseCode;
    }

    @JsonProperty("ResponseCode")
    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    @JsonProperty("Success")
    public Boolean getSuccess() {
        return success;
    }

    @JsonProperty("Success")
    public void setSuccess(Boolean success) {
        this.success = success;
    }

    @JsonProperty("HasSavedCreditCard")
    public Boolean getHasSavedCreditCard() {
        return hasSavedCreditCard;
    }

    @JsonProperty("HasSavedCreditCard")
    public void setHasSavedCreditCard(Boolean hasSavedCreditCard) {
        this.hasSavedCreditCard = hasSavedCreditCard;
    }

}

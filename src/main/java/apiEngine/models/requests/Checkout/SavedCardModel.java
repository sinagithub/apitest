package apiEngine.models.requests.Checkout;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "CardName",
        "Cvv"
})

public class SavedCardModel {

    @JsonProperty("CardName")
    private String cardName;
    @JsonProperty("Cvv")
    private String cvv;

    /**
     * No args constructor for use in serialization
     *
     */
    public SavedCardModel() {
    }

    /**
     *
     * @param cvv
     * @param cardName
     */
    public SavedCardModel(String cardName, String cvv) {
        super();
        this.cardName = cardName;
        this.cvv = cvv;
    }

    @JsonProperty("CardName")
    public String getCardName() {
        return cardName;
    }

    @JsonProperty("CardName")
    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    @JsonProperty("Cvv")
    public String getCvv() {
        return cvv;
    }

    @JsonProperty("Cvv")
    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

}
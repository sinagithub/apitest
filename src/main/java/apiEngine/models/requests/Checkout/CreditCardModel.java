package apiEngine.models.requests.Checkout;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "CardNumber",
        "ExpireYear",
        "ExpireMonth",
        "SaveCard",
        "CardName",
        "Cvv"
})

public class CreditCardModel {

    @JsonProperty("CardNumber")
    private String cardNumber;
    @JsonProperty("ExpireYear")
    private Integer expireYear;
    @JsonProperty("ExpireMonth")
    private Integer expireMonth;
    @JsonProperty("SaveCard")
    private Boolean saveCard;
    @JsonProperty("CardName")
    private String cardName;
    @JsonProperty("Cvv")
    private String cvv;

    /**
     * No args constructor for use in serialization
     *
     */
    public CreditCardModel() {
    }

    /**
     *
     * @param cvv
     * @param saveCard
     * @param cardName
     * @param expireMonth
     * @param expireYear
     * @param cardNumber
     */
    public CreditCardModel(String cardNumber, Integer expireYear, Integer expireMonth, Boolean saveCard, String cardName, String cvv) {
        super();
        this.cardNumber = cardNumber;
        this.expireYear = expireYear;
        this.expireMonth = expireMonth;
        this.saveCard = saveCard;
        this.cardName = cardName;
        this.cvv = cvv;
    }

    @JsonProperty("CardNumber")
    public String getCardNumber() {
        return cardNumber;
    }

    @JsonProperty("CardNumber")
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @JsonProperty("ExpireYear")
    public Integer getExpireYear() {
        return expireYear;
    }

    @JsonProperty("ExpireYear")
    public void setExpireYear(Integer expireYear) {
        this.expireYear = expireYear;
    }

    @JsonProperty("ExpireMonth")
    public Integer getExpireMonth() {
        return expireMonth;
    }

    @JsonProperty("ExpireMonth")
    public void setExpireMonth(Integer expireMonth) {
        this.expireMonth = expireMonth;
    }

    @JsonProperty("SaveCard")
    public Boolean getSaveCard() {
        return saveCard;
    }

    @JsonProperty("SaveCard")
    public void setSaveCard(Boolean saveCard) {
        this.saveCard = saveCard;
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
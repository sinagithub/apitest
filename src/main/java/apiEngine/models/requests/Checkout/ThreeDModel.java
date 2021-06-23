package apiEngine.models.requests.Checkout;

import javax.annotation.Generated;
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
        "Cvv",
        "Ys3DFormLogId",
        "Data3DValidationResponse"
})
@Generated("jsonschema2pojo")
public class ThreeDModel {

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
    @JsonProperty("Ys3DFormLogId")
    private Integer ys3DFormLogId;
    @JsonProperty("Data3DValidationResponse")
    private String data3DValidationResponse;

    /**
     * No args constructor for use in serialization
     *
     */
    public ThreeDModel() {
    }

    /**
     *
     * @param cvv
     * @param saveCard
     * @param cardName
     * @param data3DValidationResponse
     * @param expireMonth
     * @param expireYear
     * @param cardNumber
     * @param ys3DFormLogId
     */
    public ThreeDModel(String cardNumber, Integer expireYear, Integer expireMonth, Boolean saveCard, String cardName, String cvv, Integer ys3DFormLogId, String data3DValidationResponse) {
        super();
        this.cardNumber = cardNumber;
        this.expireYear = expireYear;
        this.expireMonth = expireMonth;
        this.saveCard = saveCard;
        this.cardName = cardName;
        this.cvv = cvv;
        this.ys3DFormLogId = ys3DFormLogId;
        this.data3DValidationResponse = data3DValidationResponse;
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

    @JsonProperty("Ys3DFormLogId")
    public Integer getYs3DFormLogId() {
        return ys3DFormLogId;
    }

    @JsonProperty("Ys3DFormLogId")
    public void setYs3DFormLogId(Integer ys3DFormLogId) {
        this.ys3DFormLogId = ys3DFormLogId;
    }

    @JsonProperty("Data3DValidationResponse")
    public String getData3DValidationResponse() {
        return data3DValidationResponse;
    }

    @JsonProperty("Data3DValidationResponse")
    public void setData3DValidationResponse(String data3DValidationResponse) {
        this.data3DValidationResponse = data3DValidationResponse;
    }

}

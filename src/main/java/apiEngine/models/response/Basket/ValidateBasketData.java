package apiEngine.models.response.Basket;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "IsValid",
        "CanBeFixed",
        "IsCouponUsed",
        "IsOtpRequired",
        "IsUserOtpValidated",
        "Basket",
        "ProductErrors",
        "CampaignErrors",
        "OtherErrors",
        "LineItemErrors",
        "ErrorMessages"
})
public class ValidateBasketData {

    @JsonProperty("IsValid")
    private Boolean isValid;
    @JsonProperty("CanBeFixed")
    private Boolean canBeFixed;
    @JsonProperty("IsCouponUsed")
    private Boolean isCouponUsed;
    @JsonProperty("IsOtpRequired")
    private Boolean isOtpRequired;
    @JsonProperty("IsUserOtpValidated")
    private Boolean isUserOtpValidated;
    @JsonProperty("Basket")
    private BasketData basket;
    @JsonProperty("ProductErrors")
    private ProductErrors productErrors;
    @JsonProperty("CampaignErrors")
    private CampaignErrors campaignErrors;
    @JsonProperty("OtherErrors")
    private List<String> otherErrors = null;
    @JsonProperty("LineItemErrors")
    private List<String> lineItemErrors = null;
    @JsonProperty("ErrorMessages")
    private List<String> errorMessages = null;

    @JsonProperty("IsValid")
    public Boolean getIsValid() {
        return isValid;
    }

    @JsonProperty("IsValid")
    public void setIsValid(Boolean isValid) {
        this.isValid = isValid;
    }

    @JsonProperty("CanBeFixed")
    public Boolean getCanBeFixed() {
        return canBeFixed;
    }

    @JsonProperty("CanBeFixed")
    public void setCanBeFixed(Boolean canBeFixed) {
        this.canBeFixed = canBeFixed;
    }

    @JsonProperty("IsCouponUsed")
    public Boolean getIsCouponUsed() {
        return isCouponUsed;
    }

    @JsonProperty("IsCouponUsed")
    public void setIsCouponUsed(Boolean isCouponUsed) {
        this.isCouponUsed = isCouponUsed;
    }

    @JsonProperty("IsOtpRequired")
    public Boolean getIsOtpRequired() {
        return isOtpRequired;
    }

    @JsonProperty("IsOtpRequired")
    public void setIsOtpRequired(Boolean isOtpRequired) {
        this.isOtpRequired = isOtpRequired;
    }

    @JsonProperty("IsUserOtpValidated")
    public Boolean getIsUserOtpValidated() {
        return isUserOtpValidated;
    }

    @JsonProperty("IsUserOtpValidated")
    public void setIsUserOtpValidated(Boolean isUserOtpValidated) {
        this.isUserOtpValidated = isUserOtpValidated;
    }

    @JsonProperty("Basket")
    public BasketData getBasket() {
        return basket;
    }

    @JsonProperty("Basket")
    public void setBasket(BasketData basket) {
        this.basket = basket;
    }

    @JsonProperty("ProductErrors")
    public ProductErrors getProductErrors() {
        return productErrors;
    }

    @JsonProperty("ProductErrors")
    public void setProductErrors(ProductErrors productErrors) {
        this.productErrors = productErrors;
    }

    @JsonProperty("CampaignErrors")
    public CampaignErrors getCampaignErrors() {
        return campaignErrors;
    }

    @JsonProperty("CampaignErrors")
    public void setCampaignErrors(CampaignErrors campaignErrors) {
        this.campaignErrors = campaignErrors;
    }

    @JsonProperty("OtherErrors")
    public List<String> getOtherErrors() {
        return otherErrors;
    }

    @JsonProperty("OtherErrors")
    public void setOtherErrors(List<String> otherErrors) {
        this.otherErrors = otherErrors;
    }

    @JsonProperty("LineItemErrors")
    public List<String> getLineItemErrors() {
        return lineItemErrors;
    }

    @JsonProperty("LineItemErrors")
    public void setLineItemErrors(List<String> lineItemErrors) {
        this.lineItemErrors = lineItemErrors;
    }

    @JsonProperty("ErrorMessages")
    public List<String> getErrorMessages() {
        return errorMessages;
    }

    @JsonProperty("ErrorMessages")
    public void setErrorMessages(List<String> errorMessages) {
        this.errorMessages = errorMessages;
    }

}

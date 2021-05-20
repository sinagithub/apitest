package apiEngine.models.response.Payment;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Name",
        "Image",
        "Pan",
        "IsMaxiMobile",
        "PointAmount",
        "BankCode",
        "CardBrand",
        "ImageHttps"
})
public class CreditCard {

    @JsonProperty("Name")
    private String name;
    @JsonProperty("Image")
    private String image;
    @JsonProperty("Pan")
    private String pan;
    @JsonProperty("IsMaxiMobile")
    private Boolean isMaxiMobile;
    @JsonProperty("PointAmount")
    private Integer pointAmount;
    @JsonProperty("BankCode")
    private String bankCode;
    @JsonProperty("CardBrand")
    private String cardBrand;
    @JsonProperty("ImageHttps")
    private String imageHttps;

    @JsonProperty("Name")
    public String getName() {
        return name;
    }

    @JsonProperty("Name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("Image")
    public String getImage() {
        return image;
    }

    @JsonProperty("Image")
    public void setImage(String image) {
        this.image = image;
    }

    @JsonProperty("Pan")
    public String getPan() {
        return pan;
    }

    @JsonProperty("Pan")
    public void setPan(String pan) {
        this.pan = pan;
    }

    @JsonProperty("IsMaxiMobile")
    public Boolean getIsMaxiMobile() {
        return isMaxiMobile;
    }

    @JsonProperty("IsMaxiMobile")
    public void setIsMaxiMobile(Boolean isMaxiMobile) {
        this.isMaxiMobile = isMaxiMobile;
    }

    @JsonProperty("PointAmount")
    public Integer getPointAmount() {
        return pointAmount;
    }

    @JsonProperty("PointAmount")
    public void setPointAmount(Integer pointAmount) {
        this.pointAmount = pointAmount;
    }

    @JsonProperty("BankCode")
    public String getBankCode() {
        return bankCode;
    }

    @JsonProperty("BankCode")
    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    @JsonProperty("CardBrand")
    public String getCardBrand() {
        return cardBrand;
    }

    @JsonProperty("CardBrand")
    public void setCardBrand(String cardBrand) {
        this.cardBrand = cardBrand;
    }

    @JsonProperty("ImageHttps")
    public String getImageHttps() {
        return imageHttps;
    }

    @JsonProperty("ImageHttps")
    public void setImageHttps(String imageHttps) {
        this.imageHttps = imageHttps;
    }

}
package apiEngine.models.response.Basket.Campaign;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonPropertyOrder({
        "Id",
        "TypeId",
        "Title",
        "DiscountType",
        "DiscountTotal",
        "ImageUrl",
        "IsDefault",
        "IsShown",
        "IsOtpRequired",
        "ShortTitle"
})

public class CampaignItem {

    @JsonProperty("Id")
    private String id;
    @JsonProperty("TypeId")
    private Integer typeId;
    @JsonProperty("Title")
    private String title;
    @JsonProperty("DiscountType")
    private String discountType;
    @JsonProperty("DiscountTotal")
    private Double discountTotal;
    @JsonProperty("ImageUrl")
    private String imageUrl;
    @JsonProperty("IsDefault")
    private Boolean isDefault;
    @JsonProperty("IsShown")
    private Boolean isShown;
    @JsonProperty("IsOtpRequired")
    private Boolean isOtpRequired;
    @JsonProperty("ShortTitle")
    private String shortTitle;

    @JsonProperty("Id")
    public String getId() {
        return id;
    }

    @JsonProperty("Id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("TypeId")
    public Integer getTypeId() {
        return typeId;
    }

    @JsonProperty("TypeId")
    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    @JsonProperty("Title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("Title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("DiscountType")
    public String getDiscountType() {
        return discountType;
    }

    @JsonProperty("DiscountType")
    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }

    @JsonProperty("DiscountTotal")
    public Double getDiscountTotal() {
        return discountTotal;
    }

    @JsonProperty("DiscountTotal")
    public void setDiscountTotal(Double discountTotal) {
        this.discountTotal = discountTotal;
    }

    @JsonProperty("ImageUrl")
    public String getImageUrl() {
        return imageUrl;
    }

    @JsonProperty("ImageUrl")
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @JsonProperty("IsDefault")
    public Boolean getIsDefault() {
        return isDefault;
    }

    @JsonProperty("IsDefault")
    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

    @JsonProperty("IsShown")
    public Boolean getIsShown() {
        return isShown;
    }

    @JsonProperty("IsShown")
    public void setIsShown(Boolean isShown) {
        this.isShown = isShown;
    }

    @JsonProperty("IsOtpRequired")
    public Boolean getIsOtpRequired() {
        return isOtpRequired;
    }

    @JsonProperty("IsOtpRequired")
    public void setIsOtpRequired(Boolean isOtpRequired) {
        this.isOtpRequired = isOtpRequired;
    }

    @JsonProperty("ShortTitle")
    public String getShortTitle() {
        return shortTitle;
    }

    @JsonProperty("ShortTitle")
    public void setShortTitle(String shortTitle) {
        this.shortTitle = shortTitle;
    }

}
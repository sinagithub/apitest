package apiEngine.models.response.Basket;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Id",
        "TypeId",
        "Title",
        "DiscountType",
        "DiscountTotal",
        "TargetQuantity",
        "ImageUrl",
        "IsShown",
        "IsDefault",
        "IsOtpRequired"
})
public class CampaignItem {

    @JsonProperty("Id")
    private Integer id;
    @JsonProperty("TypeId")
    private Integer typeId;
    @JsonProperty("Title")
    private String title;
    @JsonProperty("DiscountType")
    private Integer discountType;
    @JsonProperty("DiscountTotal")
    private Integer discountTotal;
    @JsonProperty("TargetQuantity")
    private Integer targetQuantity;
    @JsonProperty("ImageUrl")
    private String imageUrl;
    @JsonProperty("IsShown")
    private Boolean isShown;
    @JsonProperty("IsDefault")
    private Boolean isDefault;
    @JsonProperty("IsOtpRequired")
    private Boolean isOtpRequired;

    @JsonProperty("Id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("Id")
    public void setId(Integer id) {
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
    public Integer getDiscountType() {
        return discountType;
    }

    @JsonProperty("DiscountType")
    public void setDiscountType(Integer discountType) {
        this.discountType = discountType;
    }

    @JsonProperty("DiscountTotal")
    public Integer getDiscountTotal() {
        return discountTotal;
    }

    @JsonProperty("DiscountTotal")
    public void setDiscountTotal(Integer discountTotal) {
        this.discountTotal = discountTotal;
    }

    @JsonProperty("TargetQuantity")
    public Integer getTargetQuantity() {
        return targetQuantity;
    }

    @JsonProperty("TargetQuantity")
    public void setTargetQuantity(Integer targetQuantity) {
        this.targetQuantity = targetQuantity;
    }

    @JsonProperty("ImageUrl")
    public String getImageUrl() {
        return imageUrl;
    }

    @JsonProperty("ImageUrl")
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @JsonProperty("IsShown")
    public Boolean getIsShown() {
        return isShown;
    }

    @JsonProperty("IsShown")
    public void setIsShown(Boolean isShown) {
        this.isShown = isShown;
    }

    @JsonProperty("IsDefault")
    public Boolean getIsDefault() {
        return isDefault;
    }

    @JsonProperty("IsDefault")
    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

    @JsonProperty("IsOtpRequired")
    public Boolean getIsOtpRequired() {
        return isOtpRequired;
    }

    @JsonProperty("IsOtpRequired")
    public void setIsOtpRequired(Boolean isOtpRequired) {
        this.isOtpRequired = isOtpRequired;
    }

}

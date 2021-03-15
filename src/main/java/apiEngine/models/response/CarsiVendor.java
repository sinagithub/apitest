package apiEngine.models.response;

import java.util.List;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Id",
        "Name",
        "ImageUrl",
        "LogoUrl",
        "DeliveryTimeInfo",
        "MinBasketPriceInfo",
        "DeliveryFeeInfo",
        "CategoryIds",
        "CategoryName",
        "IsOpen"
})
public class CarsiVendor {

    @JsonProperty("Id")
    private String id;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("ImageUrl")
    private String imageUrl;
    @JsonProperty("LogoUrl")
    private String logoUrl;
    @JsonProperty("DeliveryTimeInfo")
    private String deliveryTimeInfo;
    @JsonProperty("MinBasketPriceInfo")
    private String minBasketPriceInfo;
    @JsonProperty("DeliveryFeeInfo")
    private String deliveryFeeInfo;
    @JsonProperty("CategoryIds")
    private List<Integer> categoryIds = null;
    @JsonProperty("CategoryName")
    private String categoryName;
    @JsonProperty("IsOpen")
    private Boolean isOpen;

    @JsonProperty("Id")
    public String getId() {
        return id;
    }

    @JsonProperty("Id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("Name")
    public String getName() {
        return name;
    }

    @JsonProperty("Name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("ImageUrl")
    public String getImageUrl() {
        return imageUrl;
    }

    @JsonProperty("ImageUrl")
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @JsonProperty("LogoUrl")
    public String getLogoUrl() {
        return logoUrl;
    }

    @JsonProperty("LogoUrl")
    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    @JsonProperty("DeliveryTimeInfo")
    public String getDeliveryTimeInfo() {
        return deliveryTimeInfo;
    }

    @JsonProperty("DeliveryTimeInfo")
    public void setDeliveryTimeInfo(String deliveryTimeInfo) {
        this.deliveryTimeInfo = deliveryTimeInfo;
    }

    @JsonProperty("MinBasketPriceInfo")
    public String getMinBasketPriceInfo() {
        return minBasketPriceInfo;
    }

    @JsonProperty("MinBasketPriceInfo")
    public void setMinBasketPriceInfo(String minBasketPriceInfo) {
        this.minBasketPriceInfo = minBasketPriceInfo;
    }

    @JsonProperty("DeliveryFeeInfo")
    public String getDeliveryFeeInfo() {
        return deliveryFeeInfo;
    }

    @JsonProperty("DeliveryFeeInfo")
    public void setDeliveryFeeInfo(String deliveryFeeInfo) {
        this.deliveryFeeInfo = deliveryFeeInfo;
    }

    @JsonProperty("CategoryIds")
    public List<Integer> getCategoryIds() {
        return categoryIds;
    }

    @JsonProperty("CategoryIds")
    public void setCategoryIds(List<Integer> categoryIds) {
        this.categoryIds = categoryIds;
    }

    @JsonProperty("CategoryName")
    public String getCategoryName() {
        return categoryName;
    }

    @JsonProperty("CategoryName")
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @JsonProperty("IsOpen")
    public Boolean getIsOpen() {
        return isOpen;
    }

    @JsonProperty("IsOpen")
    public void setIsOpen(Boolean isOpen) {
        this.isOpen = isOpen;
    }

}
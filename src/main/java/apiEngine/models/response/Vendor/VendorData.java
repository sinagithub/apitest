package apiEngine.models.response.Vendor;

import java.util.List;
import javax.annotation.Generated;

import apiEngine.models.response.Banner;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Id",
        "Name",
        "AreaName",
        "CategoryName",
        "ImageUrl",
        "LogoUrl",
        "DeliveryTimeInfo",
        "MinBasketPriceInfo",
        "DeliveryFeeInfo",
        "Banners",
        "Categories"
})
@Generated("jsonschema2pojo")
public class VendorData {

    @JsonProperty("Id")
    private String id;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("AreaName")
    private String areaName;
    @JsonProperty("CategoryName")
    private String categoryName;
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
    @JsonProperty("Banners")
    private List<Banner> banners = null;
    @JsonProperty("Categories")
    private List<Category> categories = null;

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

    @JsonProperty("AreaName")
    public String getAreaName() {
        return areaName;
    }

    @JsonProperty("AreaName")
    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    @JsonProperty("CategoryName")
    public String getCategoryName() {
        return categoryName;
    }

    @JsonProperty("CategoryName")
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
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

    @JsonProperty("Banners")
    public List<Banner> getBanners() {
        return banners;
    }

    @JsonProperty("Banners")
    public void setBanners(List<Banner> banners) {
        this.banners = banners;
    }

    @JsonProperty("Categories")
    public List<Category> getCategories() {
        return categories;
    }

    @JsonProperty("Categories")
    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

}

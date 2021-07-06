package apiEngine.models.response.Favorite;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "PlatformType",
        "Id",
        "Name",
        "LogoUrl",
        "DeliveryTimeInfo",
        "MinBasketPriceInfo",
        "DeliveryFeeInfo",
        "IsOpen",
        "IsClickable",
        "VendorStatusText",
        "CategoryName",
        "Products",
        "City",
        "HasMoreProducts"
})

public class Vendor {

    @JsonProperty("PlatformType")
    private String platformType;
    @JsonProperty("Id")
    private String id;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("LogoUrl")
    private String logoUrl;
    @JsonProperty("DeliveryTimeInfo")
    private String deliveryTimeInfo;
    @JsonProperty("MinBasketPriceInfo")
    private String minBasketPriceInfo;
    @JsonProperty("DeliveryFeeInfo")
    private String deliveryFeeInfo;
    @JsonProperty("IsOpen")
    private Boolean isOpen;
    @JsonProperty("IsClickable")
    private Boolean isClickable;
    @JsonProperty("VendorStatusText")
    private String vendorStatusText;
    @JsonProperty("CategoryName")
    private String categoryName;
    @JsonProperty("Products")
    private List<Product> products = null;
    @JsonProperty("City")
    private String city;
    @JsonProperty("HasMoreProducts")
    private Boolean hasMoreProducts;

    @JsonProperty("PlatformType")
    public String getPlatformType() {
        return platformType;
    }

    @JsonProperty("PlatformType")
    public void setPlatformType(String platformType) {
        this.platformType = platformType;
    }

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

    @JsonProperty("IsOpen")
    public Boolean getIsOpen() {
        return isOpen;
    }

    @JsonProperty("IsOpen")
    public void setIsOpen(Boolean isOpen) {
        this.isOpen = isOpen;
    }

    @JsonProperty("IsClickable")
    public Boolean getIsClickable() {
        return isClickable;
    }

    @JsonProperty("IsClickable")
    public void setIsClickable(Boolean isClickable) {
        this.isClickable = isClickable;
    }

    @JsonProperty("VendorStatusText")
    public String getVendorStatusText() {
        return vendorStatusText;
    }

    @JsonProperty("VendorStatusText")
    public void setVendorStatusText(String vendorStatusText) {
        this.vendorStatusText = vendorStatusText;
    }

    @JsonProperty("CategoryName")
    public String getCategoryName() {
        return categoryName;
    }

    @JsonProperty("CategoryName")
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @JsonProperty("Products")
    public List<Product> getProducts() {
        return products;
    }

    @JsonProperty("Products")
    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @JsonProperty("City")
    public String getCity() {
        return city;
    }

    @JsonProperty("City")
    public void setCity(String city) {
        this.city = city;
    }

    @JsonProperty("HasMoreProducts")
    public Boolean getHasMoreProducts() {
        return hasMoreProducts;
    }

    @JsonProperty("HasMoreProducts")
    public void setHasMoreProducts(Boolean hasMoreProducts) {
        this.hasMoreProducts = hasMoreProducts;
    }

}
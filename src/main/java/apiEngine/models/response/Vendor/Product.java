package apiEngine.models.response.Vendor;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.cucumber.java.eo.Do;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Id",
        "Name",
        "UnitMass",
        "ImageUrl",
        "Price",
        "DiscountedPrice",
        "MaximumSaleAmount",
        "IsActive",
        "HasOptions",
        "CategoryId",
        "BadgeType"
})

public class Product {

    @JsonProperty("Id")
    private String id;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("UnitMass")
    private String unitMass;
    @JsonProperty("ImageUrl")
    private List<String> imageUrl = null;
    @JsonProperty("Price")
    private Double price;
    @JsonProperty("DiscountedPrice")
    private Double discountedPrice;
    @JsonProperty("MaximumSaleAmount")
    private Integer maximumSaleAmount;
    @JsonProperty("IsActive")
    private Boolean isActive;
    @JsonProperty("HasOptions")
    private Boolean hasOptions;
    @JsonProperty("CategoryId")
    private String categoryId;
    @JsonProperty("BadgeType")
    private Integer badgeType;

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

    @JsonProperty("UnitMass")
    public String getUnitMass() {
        return unitMass;
    }

    @JsonProperty("UnitMass")
    public void setUnitMass(String unitMass) {
        this.unitMass = unitMass;
    }

    @JsonProperty("ImageUrl")
    public List<String> getImageUrl() {
        return imageUrl;
    }

    @JsonProperty("ImageUrl")
    public void setImageUrl(List<String> imageUrl) {
        this.imageUrl = imageUrl;
    }

    @JsonProperty("Price")
    public Double getPrice() {
        return price;
    }

    @JsonProperty("Price")
    public void setPrice(Double price) {
        this.price = price;
    }

    @JsonProperty("DiscountedPrice")
    public Double getDiscountedPrice() {
        return discountedPrice;
    }

    @JsonProperty("DiscountedPrice")
    public void setDiscountedPrice(Double discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    @JsonProperty("MaximumSaleAmount")
    public Integer getMaximumSaleAmount() {
        return maximumSaleAmount;
    }

    @JsonProperty("MaximumSaleAmount")
    public void setMaximumSaleAmount(Integer maximumSaleAmount) {
        this.maximumSaleAmount = maximumSaleAmount;
    }

    @JsonProperty("IsActive")
    public Boolean getIsActive() {
        return isActive;
    }

    @JsonProperty("IsActive")
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    @JsonProperty("HasOptions")
    public Boolean getHasOptions() {
        return hasOptions;
    }

    @JsonProperty("HasOptions")
    public void setHasOptions(Boolean hasOptions) {
        this.hasOptions = hasOptions;
    }

    @JsonProperty("CategoryId")
    public String getCategoryId() {
        return categoryId;
    }

    @JsonProperty("CategoryId")
    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    @JsonProperty("BadgeType")
    public Integer getBadgeType() {
        return badgeType;
    }

    @JsonProperty("BadgeType")
    public void setBadgeType(Integer badgeType) {
        this.badgeType = badgeType;
    }

}
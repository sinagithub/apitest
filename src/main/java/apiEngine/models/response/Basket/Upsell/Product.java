package apiEngine.models.response.Basket.Upsell;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

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
@Generated("jsonschema2pojo")
public class Product {

    @JsonProperty("Id")
    private String id;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("UnitMass")
    private String unitMass;
    @JsonProperty("ImageUrl")
    private String imageUrl;
    @JsonProperty("Price")
    private Integer price;
    @JsonProperty("DiscountedPrice")
    private Integer discountedPrice;
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
    public String getImageUrl() {
        return imageUrl;
    }

    @JsonProperty("ImageUrl")
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @JsonProperty("Price")
    public Integer getPrice() {
        return price;
    }

    @JsonProperty("Price")
    public void setPrice(Integer price) {
        this.price = price;
    }

    @JsonProperty("DiscountedPrice")
    public Integer getDiscountedPrice() {
        return discountedPrice;
    }

    @JsonProperty("DiscountedPrice")
    public void setDiscountedPrice(Integer discountedPrice) {
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

package apiEngine.models.response.ProductDetail;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;


import apiEngine.models.DoubleContextualSerializer;
import apiEngine.models.Precision;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Id",
        "Name",
        "Description",
        "UnitMass",
        "Price",
        "PriceText",
        "DiscountedPrice",
        "DiscountedPriceText",
        "IsActive",
        "BadgeType",
        "ImageUrl",
        "MaximumSaleAmount",
        "Campaigns",
        "Options",
        "IsFavorite"
})

public class Data {

    @JsonProperty("Id")
    private String id;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("Description")
    private String description;
    @JsonProperty("UnitMass")
    private String unitMass;
    @JsonProperty("Price")
    private Double price;
    @JsonProperty("PriceText")
    private String priceText;
    @JsonProperty("DiscountedPrice")
    private Integer discountedPrice;
    @JsonProperty("DiscountedPriceText")
    private String discountedPriceText;
    @JsonProperty("IsActive")
    private Boolean isActive;
    @JsonProperty("BadgeType")
    private Integer badgeType;
    @JsonProperty("ImageUrl")
    private List<String> imageUrl = null;
    @JsonProperty("MaximumSaleAmount")
    private Integer maximumSaleAmount;
    @JsonProperty("Campaigns")
    private List<Campaign> campaigns = null;
    @JsonProperty("Options")
    private List<Option> options = null;
    @JsonProperty("IsFavorite")
    private Boolean isFavorite;


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

    @JsonProperty("Description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("Description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("UnitMass")
    public String getUnitMass() {
        return unitMass;
    }

    @JsonProperty("UnitMass")
    public void setUnitMass(String unitMass) {
        this.unitMass = unitMass;
    }

    @JsonSerialize(using = DoubleContextualSerializer.class)
    @Precision(precision = 4)
    @JsonProperty("Price")
    public Double getPrice() {
        return price;
    }

    @JsonProperty("Price")
    public void setPrice(Double price) {
        BigDecimal bd = new BigDecimal(price).setScale(2, RoundingMode.FLOOR);
        this.price = bd.doubleValue();
    }

    @JsonProperty("DiscountedPrice")
    public Integer getDiscountedPrice() {
        return discountedPrice;
    }

    @JsonProperty("DiscountedPrice")
    public void setDiscountedPrice(Integer discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    @JsonProperty("IsActive")
    public Boolean getIsActive() {
        return isActive;
    }

    @JsonProperty("IsActive")
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    @JsonProperty("BadgeType")
    public Integer getBadgeType() {
        return badgeType;
    }

    @JsonProperty("BadgeType")
    public void setBadgeType(Integer badgeType) {
        this.badgeType = badgeType;
    }

    @JsonProperty("ImageUrl")
    public List<String> getImageUrl() {
        return imageUrl;
    }

    @JsonProperty("ImageUrl")
    public void setImageUrl(List<String> imageUrl) {
        this.imageUrl = imageUrl;
    }

    @JsonProperty("MaximumSaleAmount")
    public Integer getMaximumSaleAmount() {
        return maximumSaleAmount;
    }

    @JsonProperty("MaximumSaleAmount")
    public void setMaximumSaleAmount(Integer maximumSaleAmount) {
        this.maximumSaleAmount = maximumSaleAmount;
    }

    @JsonProperty("Campaigns")
    public List<Campaign> getCampaigns() {
        return campaigns;
    }

    @JsonProperty("Campaigns")
    public void setCampaigns(List<Campaign> campaigns) {
        this.campaigns = campaigns;
    }

    @JsonProperty("Options")
    public List<Option> getOptions() {
        return options;
    }

    @JsonProperty("Options")
    public void setOptions(List<Option> options) {
        this.options = options;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Boolean getFavorite() {
        return isFavorite;
    }

    public void setFavorite(Boolean favorite) {
        isFavorite = favorite;
    }

    public String getPriceText() {
        return priceText;
    }

    public void setPriceText(String priceText) {
        this.priceText = priceText;
    }

    public String getDiscountedPriceText() {
        return discountedPriceText;
    }

    public void setDiscountedPriceText(String discountedPriceText) {
        this.discountedPriceText = discountedPriceText;
    }
}

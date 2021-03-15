package apiEngine.models.response.ProductDetail;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonPropertyOrder({
        "Id",
        "Name",
        "Description",
        "UnitMass",
        "Price",
        "DiscountedPrice",
        "Stock",
        "IsActive",
        "ImageUrl",
        "MaximumSaleAmount",
        "Campaigns",
        "OptionModel"
})
public class Product {

    @JsonProperty("Id")
    private Integer id;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("Description")
    private String description;
    @JsonProperty("UnitMass")
    private String unitMass;
    @JsonProperty("Price")
    private Integer price;
    @JsonProperty("DiscountedPrice")
    private Integer discountedPrice;
    @JsonProperty("Stock")
    private Integer stock;
    @JsonProperty("IsActive")
    private Boolean isActive;
    @JsonProperty("ImageUrl")
    private String imageUrl;
    @JsonProperty("MaximumSaleAmount")
    private Integer maximumSaleAmount;
    @JsonProperty("Campaigns")
    private List<Campaign> campaigns = null;
    @JsonProperty("OptionModel")
    private OptionModel optionModel;

    @JsonProperty("Id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("Id")
    public void setId(Integer id) {
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

    @JsonProperty("Stock")
    public Integer getStock() {
        return stock;
    }

    @JsonProperty("Stock")
    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @JsonProperty("IsActive")
    public Boolean getIsActive() {
        return isActive;
    }

    @JsonProperty("IsActive")
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    @JsonProperty("ImageUrl")
    public String getImageUrl() {
        return imageUrl;
    }

    @JsonProperty("ImageUrl")
    public void setImageUrl(String imageUrl) {
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

    @JsonProperty("OptionModel")
    public OptionModel getOptionModel() {
        return optionModel;
    }

    @JsonProperty("OptionModel")
    public void setOptionModel(OptionModel optionModel) {
        this.optionModel = optionModel;
    }

}
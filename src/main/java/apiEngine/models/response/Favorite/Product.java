package apiEngine.models.response.Favorite;


import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Id",
        "Name",
        "Description",
        "UnitMass",
        "Price",
        "OriginalPrice",
        "ImageUrl",
        "IsActive",
        "HasOptions"
})

public class Product {

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
    @JsonProperty("OriginalPrice")
    private Double originalPrice;
    @JsonProperty("ImageUrl")
    private List<String> imageUrl = null;
    @JsonProperty("IsActive")
    private Boolean isActive;
    @JsonProperty("HasOptions")
    private Boolean hasOptions;

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

    @JsonProperty("Price")
    public Double getPrice() {
        return price;
    }

    @JsonProperty("Price")
    public void setPrice(Double price) {
        this.price = price;
    }

    @JsonProperty("OriginalPrice")
    public Double getOriginalPrice() {
        return originalPrice;
    }

    @JsonProperty("OriginalPrice")
    public void setOriginalPrice(Double originalPrice) {
        this.originalPrice = originalPrice;
    }

    @JsonProperty("ImageUrl")
    public List<String> getImageUrl() {
        return imageUrl;
    }

    @JsonProperty("ImageUrl")
    public void setImageUrl(List<String> imageUrl) {
        this.imageUrl = imageUrl;
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

}
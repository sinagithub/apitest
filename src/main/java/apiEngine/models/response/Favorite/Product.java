package apiEngine.models.response.Favorite;

import javax.annotation.Generated;
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
        "ImageUrl"
})
@Generated("jsonschema2pojo")
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
    private Integer price;
    @JsonProperty("OriginalPrice")
    private Integer originalPrice;
    @JsonProperty("ImageUrl")
    private String imageUrl;

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
    public Integer getPrice() {
        return price;
    }

    @JsonProperty("Price")
    public void setPrice(Integer price) {
        this.price = price;
    }

    @JsonProperty("OriginalPrice")
    public Integer getOriginalPrice() {
        return originalPrice;
    }

    @JsonProperty("OriginalPrice")
    public void setOriginalPrice(Integer originalPrice) {
        this.originalPrice = originalPrice;
    }

    @JsonProperty("ImageUrl")
    public String getImageUrl() {
        return imageUrl;
    }

    @JsonProperty("ImageUrl")
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}
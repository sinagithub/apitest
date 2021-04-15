package apiEngine.models.response.ProductDetail;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Id",
        "Name",
        "ShortName",
        "ImageUrl",
        "UnitPrice",
        "MassUnit",
        "Quantity",
        "DiscountAppliedValue",
        "IsSelected"
})
@Generated("jsonschema2pojo")
public class Product {

    @JsonProperty("Id")
    private String id;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("ShortName")
    private String shortName;
    @JsonProperty("ImageUrl")
    private String imageUrl;
    @JsonProperty("UnitPrice")
    private Integer unitPrice;
    @JsonProperty("MassUnit")
    private String massUnit;
    @JsonProperty("Quantity")
    private Integer quantity;
    @JsonProperty("DiscountAppliedValue")
    private Integer discountAppliedValue;
    @JsonProperty("IsSelected")
    private Boolean isSelected;

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

    @JsonProperty("ShortName")
    public String getShortName() {
        return shortName;
    }

    @JsonProperty("ShortName")
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    @JsonProperty("ImageUrl")
    public String getImageUrl() {
        return imageUrl;
    }

    @JsonProperty("ImageUrl")
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @JsonProperty("UnitPrice")
    public Integer getUnitPrice() {
        return unitPrice;
    }

    @JsonProperty("UnitPrice")
    public void setUnitPrice(Integer unitPrice) {
        this.unitPrice = unitPrice;
    }

    @JsonProperty("MassUnit")
    public String getMassUnit() {
        return massUnit;
    }

    @JsonProperty("MassUnit")
    public void setMassUnit(String massUnit) {
        this.massUnit = massUnit;
    }

    @JsonProperty("Quantity")
    public Integer getQuantity() {
        return quantity;
    }

    @JsonProperty("Quantity")
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @JsonProperty("DiscountAppliedValue")
    public Integer getDiscountAppliedValue() {
        return discountAppliedValue;
    }

    @JsonProperty("DiscountAppliedValue")
    public void setDiscountAppliedValue(Integer discountAppliedValue) {
        this.discountAppliedValue = discountAppliedValue;
    }

    @JsonProperty("IsSelected")
    public Boolean getIsSelected() {
        return isSelected;
    }

    @JsonProperty("IsSelected")
    public void setIsSelected(Boolean isSelected) {
        this.isSelected = isSelected;
    }

}
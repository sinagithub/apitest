package apiEngine.models.response.Basket;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
        "Id",
        "ProductId",
        "ProductName",
        "ProductDescription",
        "ProductOptions",
        "ProductUnitMass",
        "ListPrice",
        "DiscountedPrice",
        "Quantity",
        "Volume"
})

public class BasketLine {

    @JsonProperty("Id")
    private String id;
    @JsonProperty("ProductId")
    private String productId;
    @JsonProperty("ProductName")
    private String productName;
    @JsonProperty("ProductDescription")
    private String productDescription;
    @JsonProperty("ProductOptions")
    private String productOptions;
    @JsonProperty("ProductUnitMass")
    private String productUnitMass;
    @JsonProperty("ListPrice")
    private Double listPrice;
    @JsonProperty("DiscountedPrice")
    private Double discountedPrice;
    @JsonProperty("Quantity")
    private Integer quantity;
    @JsonProperty("Volume")
    private Integer volume;

    @JsonProperty("Id")
    public String getId() {
        return id;
    }

    @JsonProperty("Id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("ProductId")
    public String getProductId() {
        return productId;
    }

    @JsonProperty("ProductId")
    public void setProductId(String productId) {
        this.productId = productId;
    }

    @JsonProperty("ProductName")
    public String getProductName() {
        return productName;
    }

    @JsonProperty("ProductName")
    public void setProductName(String productName) {
        this.productName = productName;
    }

    @JsonProperty("ProductDescription")
    public String getProductDescription() {
        return productDescription;
    }

    @JsonProperty("ProductDescription")
    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    @JsonProperty("ProductOptions")
    public String getProductOptions() {
        return productOptions;
    }

    @JsonProperty("ProductOptions")
    public void setProductOptions(String productOptions) {
        this.productOptions = productOptions;
    }

    @JsonProperty("ProductUnitMass")
    public String getProductUnitMass() {
        return productUnitMass;
    }

    @JsonProperty("ProductUnitMass")
    public void setProductUnitMass(String productUnitMass) {
        this.productUnitMass = productUnitMass;
    }

    @JsonProperty("ListPrice")
    public Double getListPrice() {
        return listPrice;
    }

    @JsonProperty("ListPrice")
    public void setListPrice(Double listPrice) {
        this.listPrice = listPrice;
    }

    @JsonProperty("DiscountedPrice")
    public Double getDiscountedPrice() {
        return discountedPrice;
    }

    @JsonProperty("DiscountedPrice")
    public void setDiscountedPrice(Double discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    @JsonProperty("Quantity")
    public Integer getQuantity() {
        return quantity;
    }

    @JsonProperty("Quantity")
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @JsonProperty("Volume")
    public Integer getVolume() {
        return volume;
    }

    @JsonProperty("Volume")
    public void setVolume(Integer volume) {
        this.volume = volume;
    }

}

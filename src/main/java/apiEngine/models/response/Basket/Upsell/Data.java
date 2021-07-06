package apiEngine.models.response.Basket.Upsell;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "UpsellType",
        "Message",
        "Products"
})

public class Data {

    @JsonProperty("UpsellType")
    private Integer upsellType;
    @JsonProperty("Message")
    private String message;
    @JsonProperty("Products")
    private List<Product> products = null;

    @JsonProperty("UpsellType")
    public Integer getUpsellType() {
        return upsellType;
    }

    @JsonProperty("UpsellType")
    public void setUpsellType(Integer upsellType) {
        this.upsellType = upsellType;
    }

    @JsonProperty("Message")
    public String getMessage() {
        return message;
    }

    @JsonProperty("Message")
    public void setMessage(String message) {
        this.message = message;
    }

    @JsonProperty("Products")
    public List<Product> getProducts() {
        return products;
    }

    @JsonProperty("Products")
    public void setProducts(List<Product> products) {
        this.products = products;
    }

}
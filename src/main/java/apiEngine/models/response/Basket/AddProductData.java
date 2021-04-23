package apiEngine.models.response.Basket;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "BasketId",
        "ProductId",
        "LineItemId",
        "IsStockAvailable",
        "AvailableStock",
        "CurrentProductQuantity"
})
@Generated("jsonschema2pojo")
public class AddProductData {

    @JsonProperty("BasketId")
    private String basketId;
    @JsonProperty("ProductId")
    private String productId;
    @JsonProperty("LineItemId")
    private String lineItemId;
    @JsonProperty("IsStockAvailable")
    private Boolean isStockAvailable;
    @JsonProperty("AvailableStock")
    private Integer availableStock;
    @JsonProperty("CurrentProductQuantity")
    private Integer currentProductQuantity;

    @JsonProperty("BasketId")
    public String getBasketId() {
        return basketId;
    }

    @JsonProperty("BasketId")
    public void setBasketId(String basketId) {
        this.basketId = basketId;
    }

    @JsonProperty("ProductId")
    public String getProductId() {
        return productId;
    }

    @JsonProperty("ProductId")
    public void setProductId(String productId) {
        this.productId = productId;
    }

    @JsonProperty("LineItemId")
    public String getLineItemId() {
        return lineItemId;
    }

    @JsonProperty("LineItemId")
    public void setLineItemId(String lineItemId) {
        this.lineItemId = lineItemId;
    }

    @JsonProperty("IsStockAvailable")
    public Boolean getIsStockAvailable() {
        return isStockAvailable;
    }

    @JsonProperty("IsStockAvailable")
    public void setIsStockAvailable(Boolean isStockAvailable) {
        this.isStockAvailable = isStockAvailable;
    }

    @JsonProperty("AvailableStock")
    public Integer getAvailableStock() {
        return availableStock;
    }

    @JsonProperty("AvailableStock")
    public void setAvailableStock(Integer availableStock) {
        this.availableStock = availableStock;
    }

    @JsonProperty("CurrentProductQuantity")
    public Integer getCurrentProductQuantity() {
        return currentProductQuantity;
    }

    @JsonProperty("CurrentProductQuantity")
    public void setCurrentProductQuantity(Integer currentProductQuantity) {
        this.currentProductQuantity = currentProductQuantity;
    }

}
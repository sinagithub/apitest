package apiEngine.models.requests.Basket;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "ProductId",
        "LineItemId",
        "Quantity"
})

public class DeleteProductRequest {

    @JsonProperty("ProductId")
    private String productId;
    @JsonProperty("LineItemId")
    private String lineItemId;
    @JsonProperty("Quantity")
    private Integer quantity;

    /**
     * No args constructor for use in serialization
     *
     */
    public DeleteProductRequest() {
    }

    /**
     *
     * @param quantity
     * @param productId
     * @param lineItemId
     */
    public DeleteProductRequest(String productId, String lineItemId, Integer quantity) {
        super();
        this.productId = productId;
        this.lineItemId = lineItemId;
        this.quantity = quantity;
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

    @JsonProperty("Quantity")
    public Integer getQuantity() {
        return quantity;
    }

    @JsonProperty("Quantity")
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

}

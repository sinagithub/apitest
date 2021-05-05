package apiEngine.models.requests.Favorite;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "ProductId"
})

public class AddFavoriteProductRequest {

    @JsonProperty("ProductId")
    private String productId;

    /**
     * No args constructor for use in serialization
     *
     */
    public AddFavoriteProductRequest() {
    }

    /**
     *
     * @param productId
     */
    public AddFavoriteProductRequest(String productId) {
        super();
        this.productId = productId;
    }

    @JsonProperty("ProductId")
    public String getProductId() {
        return productId;
    }

    @JsonProperty("ProductId")
    public void setProductId(String productId) {
        this.productId = productId;
    }

}
package apiEngine.models.response.Basket;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "BasketId"
})

public class BasketIdData {

    @JsonProperty("BasketId")
    private String basketId;

    @JsonProperty("BasketId")
    public String getBasketId() {
        return basketId;
    }

    @JsonProperty("BasketId")
    public void setBasketId(String basketId) {
        this.basketId = basketId;
    }

}
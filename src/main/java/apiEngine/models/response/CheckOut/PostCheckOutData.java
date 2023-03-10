package apiEngine.models.response.CheckOut;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "OrderId"
})

public class PostCheckOutData {

    @JsonProperty("OrderId")
    private String orderId;

    @JsonProperty("OrderId")
    public String getOrderId() {
        return orderId;
    }

    @JsonProperty("OrderId")
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

}
package apiEngine.models.response.Order;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "ActiveOrders"
})
public class ActiveOrderData {

    @JsonProperty("ActiveOrders")
    private List<ActiveOrder> activeOrders = null;

    @JsonProperty("ActiveOrders")
    public List<ActiveOrder> getActiveOrders() {
        return activeOrders;
    }

    @JsonProperty("ActiveOrders")
    public void setActiveOrders(List<ActiveOrder> activeOrders) {
        this.activeOrders = activeOrders;
    }

}

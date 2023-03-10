package apiEngine.models.response.Basket.Checkout;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonPropertyOrder({
        "Now",
        "Future"
})

public class DeliveryTimeOptions {

    @JsonProperty("Now")
    private Now now;
    @JsonProperty("Future")
    private Future future;

    @JsonProperty("Now")
    public Now getNow() {
        return now;
    }

    @JsonProperty("Now")
    public void setNow(Now now) {
        this.now = now;
    }

    @JsonProperty("Future")
    public Future getFuture() {
        return future;
    }

    @JsonProperty("Future")
    public void setFuture(Future future) {
        this.future = future;
    }

}

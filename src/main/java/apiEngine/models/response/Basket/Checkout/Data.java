package apiEngine.models.response.Basket.Checkout;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "IsValid",
        "CanBeFixed",
        "IsCouponUsed",
        "BasketCheckout"
})
@Generated("jsonschema2pojo")
public class Data {

    @JsonProperty("IsValid")
    private Boolean isValid;
    @JsonProperty("CanBeFixed")
    private Boolean canBeFixed;
    @JsonProperty("IsCouponUsed")
    private Boolean isCouponUsed;
    @JsonProperty("BasketCheckout")
    private BasketCheckout basketCheckout;

    @JsonProperty("IsValid")
    public Boolean getIsValid() {
        return isValid;
    }

    @JsonProperty("IsValid")
    public void setIsValid(Boolean isValid) {
        this.isValid = isValid;
    }

    @JsonProperty("CanBeFixed")
    public Boolean getCanBeFixed() {
        return canBeFixed;
    }

    @JsonProperty("CanBeFixed")
    public void setCanBeFixed(Boolean canBeFixed) {
        this.canBeFixed = canBeFixed;
    }

    @JsonProperty("IsCouponUsed")
    public Boolean getIsCouponUsed() {
        return isCouponUsed;
    }

    @JsonProperty("IsCouponUsed")
    public void setIsCouponUsed(Boolean isCouponUsed) {
        this.isCouponUsed = isCouponUsed;
    }

    @JsonProperty("BasketCheckout")
    public BasketCheckout getBasketCheckout() {
        return basketCheckout;
    }

    @JsonProperty("BasketCheckout")
    public void setBasketCheckout(BasketCheckout basketCheckout) {
        this.basketCheckout = basketCheckout;
    }

}

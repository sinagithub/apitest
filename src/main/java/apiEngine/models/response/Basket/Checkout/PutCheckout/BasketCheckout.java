package apiEngine.models.response.Basket.Checkout.PutCheckout;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "BasketInfo",
        "ContactlessDelivery",
        "TipInfo",
        "DonationInfo",
        "PaymentInfo"
})

public class BasketCheckout {

    @JsonProperty("BasketInfo")
    private BasketInfo basketInfo;
    @JsonProperty("ContactlessDelivery")
    private Boolean contactlessDelivery;
    @JsonProperty("TipInfo")
    private TipInfo tipInfo;
    @JsonProperty("DonationInfo")
    private DonationInfo donationInfo;
    @JsonProperty("PaymentInfo")
    private PaymentInfo paymentInfo;

    @JsonProperty("BasketInfo")
    public BasketInfo getBasketInfo() {
        return basketInfo;
    }

    @JsonProperty("BasketInfo")
    public void setBasketInfo(BasketInfo basketInfo) {
        this.basketInfo = basketInfo;
    }

    @JsonProperty("ContactlessDelivery")
    public Boolean getContactlessDelivery() {
        return contactlessDelivery;
    }

    @JsonProperty("ContactlessDelivery")
    public void setContactlessDelivery(Boolean contactlessDelivery) {
        this.contactlessDelivery = contactlessDelivery;
    }

    @JsonProperty("TipInfo")
    public TipInfo getTipInfo() {
        return tipInfo;
    }

    @JsonProperty("TipInfo")
    public void setTipInfo(TipInfo tipInfo) {
        this.tipInfo = tipInfo;
    }

    @JsonProperty("DonationInfo")
    public DonationInfo getDonationInfo() {
        return donationInfo;
    }

    @JsonProperty("DonationInfo")
    public void setDonationInfo(DonationInfo donationInfo) {
        this.donationInfo = donationInfo;
    }

    @JsonProperty("PaymentInfo")
    public PaymentInfo getPaymentInfo() {
        return paymentInfo;
    }

    @JsonProperty("PaymentInfo")
    public void setPaymentInfo(PaymentInfo paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

}

package apiEngine.models.requests.Basket.Checkout;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
        "LastChangedProperty",
        "ContactlessDelivery",
        "Tip",
        "Donation",
        "Payment"
})

public class BasketCheckOutRequest {

    @JsonProperty("LastChangedProperty")
    private Integer lastChangedProperty;
    @JsonProperty("ContactlessDelivery")
    private Boolean contactlessDelivery;
    @JsonProperty("Tip")
    private Tip tip;
    @JsonProperty("Donation")
    private Donation donation;
    @JsonProperty("Payment")
    private Payment payment;

    /**
     * No args constructor for use in serialization
     *
     */
    public BasketCheckOutRequest() {
    }

    /**
     *
     * @param lastChangedProperty
     * @param contactlessDelivery
     * @param donation
     * @param tip
     * @param payment
     */
    public BasketCheckOutRequest(Integer lastChangedProperty, Boolean contactlessDelivery, Tip tip, Donation donation, Payment payment) {
        super();
        this.lastChangedProperty = lastChangedProperty;
        this.contactlessDelivery = contactlessDelivery;
        this.tip = tip;
        this.donation = donation;
        this.payment = payment;
    }

    @JsonProperty("LastChangedProperty")
    public Integer getLastChangedProperty() {
        return lastChangedProperty;
    }

    @JsonProperty("LastChangedProperty")
    public void setLastChangedProperty(Integer lastChangedProperty) {
        this.lastChangedProperty = lastChangedProperty;
    }

    @JsonProperty("ContactlessDelivery")
    public Boolean getContactlessDelivery() {
        return contactlessDelivery;
    }

    @JsonProperty("ContactlessDelivery")
    public void setContactlessDelivery(Boolean contactlessDelivery) {
        this.contactlessDelivery = contactlessDelivery;
    }

    @JsonProperty("Tip")
    public Tip getTip() {
        return tip;
    }

    @JsonProperty("Tip")
    public void setTip(Tip tip) {
        this.tip = tip;
    }

    @JsonProperty("Donation")
    public Donation getDonation() {
        return donation;
    }

    @JsonProperty("Donation")
    public void setDonation(Donation donation) {
        this.donation = donation;
    }

    @JsonProperty("Payment")
    public Payment getPayment() {
        return payment;
    }

    @JsonProperty("Payment")
    public void setPayment(Payment payment) {
        this.payment = payment;
    }

}

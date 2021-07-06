package apiEngine.models.response.Basket.Checkout;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
        "BasketInfo",
        "ShowContactlessDeliveryOption",
        "TipInfo",
        "DonationInfo",
        "PaymentTypes",
        "SavedNotes",
        "Addresses",
        "DeliveryTimeOptions"
})

public class BasketCheckout {

    @JsonProperty("BasketInfo")
    private BasketInfo basketInfo;
    @JsonProperty("ShowContactlessDeliveryOption")
    private Boolean showContactlessDeliveryOption;
    @JsonProperty("TipInfo")
    private TipInfo tipInfo;
    @JsonProperty("DonationInfo")
    private DonationInfo donationInfo;
    @JsonProperty("PaymentTypes")
    private List<PaymentType> paymentTypes = null;
    @JsonProperty("SavedNotes")
    private List<SavedNote> savedNotes = null;
    @JsonProperty("Addresses")
    private List<Address> addresses = null;
    @JsonProperty("DeliveryTimeOptions")
    private DeliveryTimeOptions deliveryTimeOptions;

    @JsonProperty("BasketInfo")
    public BasketInfo getBasketInfo() {
        return basketInfo;
    }

    @JsonProperty("BasketInfo")
    public void setBasketInfo(BasketInfo basketInfo) {
        this.basketInfo = basketInfo;
    }

    @JsonProperty("ShowContactlessDeliveryOption")
    public Boolean getShowContactlessDeliveryOption() {
        return showContactlessDeliveryOption;
    }

    @JsonProperty("ShowContactlessDeliveryOption")
    public void setShowContactlessDeliveryOption(Boolean showContactlessDeliveryOption) {
        this.showContactlessDeliveryOption = showContactlessDeliveryOption;
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

    @JsonProperty("PaymentTypes")
    public List<PaymentType> getPaymentTypes() {
        return paymentTypes;
    }

    @JsonProperty("PaymentTypes")
    public void setPaymentTypes(List<PaymentType> paymentTypes) {
        this.paymentTypes = paymentTypes;
    }

    @JsonProperty("SavedNotes")
    public List<SavedNote> getSavedNotes() {
        return savedNotes;
    }

    @JsonProperty("SavedNotes")
    public void setSavedNotes(List<SavedNote> savedNotes) {
        this.savedNotes = savedNotes;
    }

    @JsonProperty("Addresses")
    public List<Address> getAddresses() {
        return addresses;
    }

    @JsonProperty("Addresses")
    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    @JsonProperty("DeliveryTimeOptions")
    public DeliveryTimeOptions getDeliveryTimeOptions() {
        return deliveryTimeOptions;
    }

    @JsonProperty("DeliveryTimeOptions")
    public void setDeliveryTimeOptions(DeliveryTimeOptions deliveryTimeOptions) {
        this.deliveryTimeOptions = deliveryTimeOptions;
    }

}
package apiEngine.models.requests.Checkout;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "CheckoutType",
        "BasketId",
        "BasketTotal",
        "UserNote",
        "PaymentGroupId",
        "IsFutureOrder",
        "AddressId",
        "AlternateProductOptionType",
        "IsContactlessDelivery",
        "OrderDateTime",
        "SelectedSlot",
        "UsePoints",
        "ThreeDModel",
        "SavedCardModel",
        "CreditCardModel",
        "TipAndDonationInfo"
})

public class PostCheckoutRequest {

    @JsonProperty("CheckoutType")
    private Integer checkoutType;
    @JsonProperty("BasketId")
    private String basketId;
    @JsonProperty("BasketTotal")
    private Double basketTotal;
    @JsonProperty("UserNote")
    private String userNote;
    @JsonProperty("PaymentGroupId")
    private String paymentGroupId;
    @JsonProperty("IsFutureOrder")
    private Boolean isFutureOrder;
    @JsonProperty("AddressId")
    private String addressId;
    @JsonProperty("AlternateProductOptionType")
    private Integer alternateProductOptionType;
    @JsonProperty("IsContactlessDelivery")
    private Boolean isContactlessDelivery;
    @JsonProperty("OrderDateTime")
    private String orderDateTime;
    @JsonProperty("SelectedSlot")
    private String selectedSlot;
    @JsonProperty("UsePoints")
    private Boolean usePoints;
    @JsonProperty("ThreeDModel")
    private ThreeDModel threeDModel;
    @JsonProperty("SavedCardModel")
    private SavedCardModel savedCardModel;
    @JsonProperty("CreditCardModel")
    private CreditCardModel creditCardModel;
    @JsonProperty("TipAndDonationInfo")
    private TipAndDonationInfo tipAndDonationInfo;

    /**
     * No args constructor for use in serialization
     *
     */
    public PostCheckoutRequest() {
    }

    /**
     *
     * @param orderDateTime
     * @param basketId
     * @param userNote
     * @param basketTotal
     * @param tipAndDonationInfo
     * @param checkoutType
     * @param addressId
     * @param paymentGroupId
     * @param threeDModel
     * @param alternateProductOptionType
     * @param selectedSlot
     * @param savedCardModel
     * @param isContactlessDelivery
     * @param usePoints
     * @param isFutureOrder
     * @param creditCardModel
     */
    public PostCheckoutRequest(Integer checkoutType, String basketId, Double basketTotal, String userNote, String paymentGroupId, Boolean isFutureOrder, String addressId, Integer alternateProductOptionType, Boolean isContactlessDelivery, String orderDateTime, String selectedSlot, Boolean usePoints, ThreeDModel threeDModel, SavedCardModel savedCardModel, CreditCardModel creditCardModel, TipAndDonationInfo tipAndDonationInfo) {
        super();
        this.checkoutType = checkoutType;
        this.basketId = basketId;
        this.basketTotal = basketTotal;
        this.userNote = userNote;
        this.paymentGroupId = paymentGroupId;
        this.isFutureOrder = isFutureOrder;
        this.addressId = addressId;
        this.alternateProductOptionType = alternateProductOptionType;
        this.isContactlessDelivery = isContactlessDelivery;
        this.orderDateTime = orderDateTime;
        this.selectedSlot = selectedSlot;
        this.usePoints = usePoints;
        this.threeDModel = threeDModel;
        this.savedCardModel = savedCardModel;
        this.creditCardModel = creditCardModel;
        this.tipAndDonationInfo = tipAndDonationInfo;
    }

    @JsonProperty("CheckoutType")
    public Integer getCheckoutType() {
        return checkoutType;
    }

    @JsonProperty("CheckoutType")
    public void setCheckoutType(Integer checkoutType) {
        this.checkoutType = checkoutType;
    }

    @JsonProperty("BasketId")
    public String getBasketId() {
        return basketId;
    }

    @JsonProperty("BasketId")
    public void setBasketId(String basketId) {
        this.basketId = basketId;
    }

    @JsonProperty("BasketTotal")
    public Double getBasketTotal() {
        return basketTotal;
    }

    @JsonProperty("BasketTotal")
    public void setBasketTotal(Double basketTotal) {
        this.basketTotal = basketTotal;
    }

    @JsonProperty("UserNote")
    public String getUserNote() {
        return userNote;
    }

    @JsonProperty("UserNote")
    public void setUserNote(String userNote) {
        this.userNote = userNote;
    }

    @JsonProperty("PaymentGroupId")
    public String getPaymentGroupId() {
        return paymentGroupId;
    }

    @JsonProperty("PaymentGroupId")
    public void setPaymentGroupId(String paymentGroupId) {
        this.paymentGroupId = paymentGroupId;
    }

    @JsonProperty("IsFutureOrder")
    public Boolean getIsFutureOrder() {
        return isFutureOrder;
    }

    @JsonProperty("IsFutureOrder")
    public void setIsFutureOrder(Boolean isFutureOrder) {
        this.isFutureOrder = isFutureOrder;
    }

    @JsonProperty("AddressId")
    public String getAddressId() {
        return addressId;
    }

    @JsonProperty("AddressId")
    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    @JsonProperty("AlternateProductOptionType")
    public Integer getAlternateProductOptionType() {
        return alternateProductOptionType;
    }

    @JsonProperty("AlternateProductOptionType")
    public void setAlternateProductOptionType(Integer alternateProductOptionType) {
        this.alternateProductOptionType = alternateProductOptionType;
    }

    @JsonProperty("IsContactlessDelivery")
    public Boolean getIsContactlessDelivery() {
        return isContactlessDelivery;
    }

    @JsonProperty("IsContactlessDelivery")
    public void setIsContactlessDelivery(Boolean isContactlessDelivery) {
        this.isContactlessDelivery = isContactlessDelivery;
    }

    @JsonProperty("OrderDateTime")
    public String getOrderDateTime() {
        return orderDateTime;
    }

    @JsonProperty("OrderDateTime")
    public void setOrderDateTime(String orderDateTime) {
        this.orderDateTime = orderDateTime;
    }

    @JsonProperty("SelectedSlot")
    public String getSelectedSlot() {
        return selectedSlot;
    }

    @JsonProperty("SelectedSlot")
    public void setSelectedSlot(String selectedSlot) {
        this.selectedSlot = selectedSlot;
    }

    @JsonProperty("UsePoints")
    public Boolean getUsePoints() {
        return usePoints;
    }

    @JsonProperty("UsePoints")
    public void setUsePoints(Boolean usePoints) {
        this.usePoints = usePoints;
    }

    @JsonProperty("ThreeDModel")
    public ThreeDModel getThreeDModel() {
        return threeDModel;
    }

    @JsonProperty("ThreeDModel")
    public void setThreeDModel(ThreeDModel threeDModel) {
        this.threeDModel = threeDModel;
    }

    @JsonProperty("SavedCardModel")
    public SavedCardModel getSavedCardModel() {
        return savedCardModel;
    }

    @JsonProperty("SavedCardModel")
    public void setSavedCardModel(SavedCardModel savedCardModel) {
        this.savedCardModel = savedCardModel;
    }

    @JsonProperty("CreditCardModel")
    public CreditCardModel getCreditCardModel() {
        return creditCardModel;
    }

    @JsonProperty("CreditCardModel")
    public void setCreditCardModel(CreditCardModel creditCardModel) {
        this.creditCardModel = creditCardModel;
    }

    @JsonProperty("TipAndDonationInfo")
    public TipAndDonationInfo getTipAndDonationInfo() {
        return tipAndDonationInfo;
    }

    @JsonProperty("TipAndDonationInfo")
    public void setTipAndDonationInfo(TipAndDonationInfo tipAndDonationInfo) {
        this.tipAndDonationInfo = tipAndDonationInfo;
    }

}
package apiEngine.models.response.Basket.Checkout.PutCheckout;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "BasketId",
        "BasketStatus",
        "IsFreeOrder",
        "VendorId",
        "UserId",
        "MinimumDeliveryTotal",
        "TipTotal",
        "DonationTotal",
        "DeliveryFree",
        "Total",
        "SubTotal",
        "DiscountTotal",
        "LineItemsTotal",
        "BagQuantity",
        "BagTotal",
        "DiscountedDeliveryFee"
})

public class BasketInfo {

    @JsonProperty("BasketId")
    private String basketId;
    @JsonProperty("BasketStatus")
    private Integer basketStatus;
    @JsonProperty("IsFreeOrder")
    private Boolean isFreeOrder;
    @JsonProperty("VendorId")
    private String vendorId;
    @JsonProperty("UserId")
    private String userId;
    @JsonProperty("MinimumDeliveryTotal")
    private Double minimumDeliveryTotal;
    @JsonProperty("TipTotal")
    private Integer tipTotal;
    @JsonProperty("DonationTotal")
    private Integer donationTotal;
    @JsonProperty("DeliveryFree")
    private Double deliveryFree;
    @JsonProperty("Total")
    private Double total;
    @JsonProperty("SubTotal")
    private Double subTotal;
    @JsonProperty("DiscountTotal")
    private Integer discountTotal;
    @JsonProperty("LineItemsTotal")
    private Double lineItemsTotal;
    @JsonProperty("BagQuantity")
    private Integer bagQuantity;
    @JsonProperty("BagTotal")
    private Integer bagTotal;
    @JsonProperty("DiscountedDeliveryFee")
    private Double discountedDeliveryFee;

    @JsonProperty("BasketId")
    public String getBasketId() {
        return basketId;
    }

    @JsonProperty("BasketId")
    public void setBasketId(String basketId) {
        this.basketId = basketId;
    }

    @JsonProperty("BasketStatus")
    public Integer getBasketStatus() {
        return basketStatus;
    }

    @JsonProperty("BasketStatus")
    public void setBasketStatus(Integer basketStatus) {
        this.basketStatus = basketStatus;
    }

    @JsonProperty("IsFreeOrder")
    public Boolean getIsFreeOrder() {
        return isFreeOrder;
    }

    @JsonProperty("IsFreeOrder")
    public void setIsFreeOrder(Boolean isFreeOrder) {
        this.isFreeOrder = isFreeOrder;
    }

    @JsonProperty("VendorId")
    public String getVendorId() {
        return vendorId;
    }

    @JsonProperty("VendorId")
    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    @JsonProperty("UserId")
    public String getUserId() {
        return userId;
    }

    @JsonProperty("UserId")
    public void setUserId(String userId) {
        this.userId = userId;
    }

    @JsonProperty("MinimumDeliveryTotal")
    public Double getMinimumDeliveryTotal() {
        return minimumDeliveryTotal;
    }

    @JsonProperty("MinimumDeliveryTotal")
    public void setMinimumDeliveryTotal(Double minimumDeliveryTotal) {
        this.minimumDeliveryTotal = minimumDeliveryTotal;
    }

    @JsonProperty("TipTotal")
    public Integer getTipTotal() {
        return tipTotal;
    }

    @JsonProperty("TipTotal")
    public void setTipTotal(Integer tipTotal) {
        this.tipTotal = tipTotal;
    }

    @JsonProperty("DonationTotal")
    public Integer getDonationTotal() {
        return donationTotal;
    }

    @JsonProperty("DonationTotal")
    public void setDonationTotal(Integer donationTotal) {
        this.donationTotal = donationTotal;
    }

    @JsonProperty("DeliveryFree")
    public Double getDeliveryFree() {
        return deliveryFree;
    }

    @JsonProperty("DeliveryFree")
    public void setDeliveryFree(Double deliveryFree) {
        this.deliveryFree = deliveryFree;
    }

    @JsonProperty("Total")
    public Double getTotal() {
        return total;
    }

    @JsonProperty("Total")
    public void setTotal(Double total) {
        this.total = total;
    }

    @JsonProperty("SubTotal")
    public Double getSubTotal() {
        return subTotal;
    }

    @JsonProperty("SubTotal")
    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    @JsonProperty("DiscountTotal")
    public Integer getDiscountTotal() {
        return discountTotal;
    }

    @JsonProperty("DiscountTotal")
    public void setDiscountTotal(Integer discountTotal) {
        this.discountTotal = discountTotal;
    }

    @JsonProperty("LineItemsTotal")
    public Double getLineItemsTotal() {
        return lineItemsTotal;
    }

    @JsonProperty("LineItemsTotal")
    public void setLineItemsTotal(Double lineItemsTotal) {
        this.lineItemsTotal = lineItemsTotal;
    }

    @JsonProperty("BagQuantity")
    public Integer getBagQuantity() {
        return bagQuantity;
    }

    @JsonProperty("BagQuantity")
    public void setBagQuantity(Integer bagQuantity) {
        this.bagQuantity = bagQuantity;
    }

    @JsonProperty("BagTotal")
    public Integer getBagTotal() {
        return bagTotal;
    }

    @JsonProperty("BagTotal")
    public void setBagTotal(Integer bagTotal) {
        this.bagTotal = bagTotal;
    }

    @JsonProperty("DiscountedDeliveryFee")
    public Double getDiscountedDeliveryFee() {
        return discountedDeliveryFee;
    }

    @JsonProperty("DiscountedDeliveryFee")
    public void setDiscountedDeliveryFee(Double discountedDeliveryFee) {
        this.discountedDeliveryFee = discountedDeliveryFee;
    }

}

package apiEngine.models.response.Basket.Checkout;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
        "BasketId",
        "BasketStatus",
        "IsFreeOrder",
        "TipTotal",
        "DonationTotal",
        "DeliveryFee",
        "Total",
        "DiscountTotal",
        "LineItemsTotal",
        "BagQuantity",
        "BagTotal",
        "DiscountedDeliveryFee",
        "VendorId"
})

public class BasketInfo {

    @JsonProperty("BasketId")
    private String basketId;
    @JsonProperty("BasketStatus")
    private Integer basketStatus;
    @JsonProperty("IsFreeOrder")
    private Boolean isFreeOrder;
    @JsonProperty("TipTotal")
    private Double tipTotal;
    @JsonProperty("DonationTotal")
    private Double donationTotal;
    @JsonProperty("DeliveryFee")
    private Double deliveryFee;
    @JsonProperty("Total")
    private Double total;
    @JsonProperty("DiscountTotal")
    private Double discountTotal;
    @JsonProperty("LineItemsTotal")
    private Double lineItemsTotal;
    @JsonProperty("BagQuantity")
    private Integer bagQuantity;
    @JsonProperty("BagTotal")
    private Double bagTotal;
    @JsonProperty("DiscountedDeliveryFee")
    private Double discountedDeliveryFee;
    @JsonProperty("VendorId")
    private String vendorId;

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

    @JsonProperty("TipTotal")
    public Double getTipTotal() {
        return tipTotal;
    }

    @JsonProperty("TipTotal")
    public void setTipTotal(Double tipTotal) {
        this.tipTotal = tipTotal;
    }

    @JsonProperty("DonationTotal")
    public Double getDonationTotal() {
        return donationTotal;
    }

    @JsonProperty("DonationTotal")
    public void setDonationTotal(Double donationTotal) {
        this.donationTotal = donationTotal;
    }

    @JsonProperty("DeliveryFee")
    public Double getDeliveryFee() {
        return deliveryFee;
    }

    @JsonProperty("DeliveryFee")
    public void setDeliveryFee(Double deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    @JsonProperty("Total")
    public Double getTotal() {
        return total;
    }

    @JsonProperty("Total")
    public void setTotal(Double total) {
        this.total = total;
    }

    @JsonProperty("DiscountTotal")
    public Double getDiscountTotal() {
        return discountTotal;
    }

    @JsonProperty("DiscountTotal")
    public void setDiscountTotal(Double discountTotal) {
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
    public Double getBagTotal() {
        return bagTotal;
    }

    @JsonProperty("BagTotal")
    public void setBagTotal(Double bagTotal) {
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

    @JsonProperty("VendorId")
    public String getVendorId() {
        return vendorId;
    }

    @JsonProperty("VendorId")
    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

}
package apiEngine.models.response.Basket;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "BasketId",
        "BasketStatus",
        "IsFreeOrder",
        "VendorId",
        "VendorName",
        "UserId",
        "MinimumDeliveryTotal",
        "DeliveryFree",
        "Total",
        "SubTotal"
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
    @JsonProperty("VendorName")
    private String vendorName;
    @JsonProperty("UserId")
    private String userId;
    @JsonProperty("MinimumDeliveryTotal")
    private Integer minimumDeliveryTotal;
    @JsonProperty("DeliveryFree")
    private Integer deliveryFree;
    @JsonProperty("Total")
    private Integer total;
    @JsonProperty("SubTotal")
    private Integer subTotal;

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

    @JsonProperty("VendorName")
    public String getVendorName() {
        return vendorName;
    }

    @JsonProperty("VendorName")
    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
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
    public Integer getMinimumDeliveryTotal() {
        return minimumDeliveryTotal;
    }

    @JsonProperty("MinimumDeliveryTotal")
    public void setMinimumDeliveryTotal(Integer minimumDeliveryTotal) {
        this.minimumDeliveryTotal = minimumDeliveryTotal;
    }

    @JsonProperty("DeliveryFree")
    public Integer getDeliveryFree() {
        return deliveryFree;
    }

    @JsonProperty("DeliveryFree")
    public void setDeliveryFree(Integer deliveryFree) {
        this.deliveryFree = deliveryFree;
    }

    @JsonProperty("Total")
    public Integer getTotal() {
        return total;
    }

    @JsonProperty("Total")
    public void setTotal(Integer total) {
        this.total = total;
    }

    @JsonProperty("SubTotal")
    public Integer getSubTotal() {
        return subTotal;
    }

    @JsonProperty("SubTotal")
    public void setSubTotal(Integer subTotal) {
        this.subTotal = subTotal;
    }

}

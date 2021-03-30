package apiEngine.models.response.Order;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "VendorName",
        "PlatformType",
        "DeliveryType",
        "TrackingNumber",
        "CreatedDate",
        "Status",
        "StatusText",
        "RegionName",
        "TotalAmount",
        "PaymentMethod",
        "DeliveryTime",
        "IsFreeOrder"
})
public class ActiveOrder {

    @JsonProperty("VendorName")
    private String vendorName;
    @JsonProperty("PlatformType")
    private Integer platformType;
    @JsonProperty("DeliveryType")
    private Integer deliveryType;
    @JsonProperty("TrackingNumber")
    private String trackingNumber;
    @JsonProperty("CreatedDate")
    private String createdDate;
    @JsonProperty("Status")
    private Integer status;
    @JsonProperty("StatusText")
    private String statusText;
    @JsonProperty("RegionName")
    private String regionName;
    @JsonProperty("TotalAmount")
    private Integer totalAmount;
    @JsonProperty("PaymentMethod")
    private String paymentMethod;
    @JsonProperty("DeliveryTime")
    private String deliveryTime;
    @JsonProperty("IsFreeOrder")
    private Boolean isFreeOrder;

    @JsonProperty("VendorName")
    public String getVendorName() {
        return vendorName;
    }

    @JsonProperty("VendorName")
    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    @JsonProperty("PlatformType")
    public Integer getPlatformType() {
        return platformType;
    }

    @JsonProperty("PlatformType")
    public void setPlatformType(Integer platformType) {
        this.platformType = platformType;
    }

    @JsonProperty("DeliveryType")
    public Integer getDeliveryType() {
        return deliveryType;
    }

    @JsonProperty("DeliveryType")
    public void setDeliveryType(Integer deliveryType) {
        this.deliveryType = deliveryType;
    }

    @JsonProperty("TrackingNumber")
    public String getTrackingNumber() {
        return trackingNumber;
    }

    @JsonProperty("TrackingNumber")
    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    @JsonProperty("CreatedDate")
    public String getCreatedDate() {
        return createdDate;
    }

    @JsonProperty("CreatedDate")
    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    @JsonProperty("Status")
    public Integer getStatus() {
        return status;
    }

    @JsonProperty("Status")
    public void setStatus(Integer status) {
        this.status = status;
    }

    @JsonProperty("StatusText")
    public String getStatusText() {
        return statusText;
    }

    @JsonProperty("StatusText")
    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    @JsonProperty("RegionName")
    public String getRegionName() {
        return regionName;
    }

    @JsonProperty("RegionName")
    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    @JsonProperty("TotalAmount")
    public Integer getTotalAmount() {
        return totalAmount;
    }

    @JsonProperty("TotalAmount")
    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    @JsonProperty("PaymentMethod")
    public String getPaymentMethod() {
        return paymentMethod;
    }

    @JsonProperty("PaymentMethod")
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @JsonProperty("DeliveryTime")
    public String getDeliveryTime() {
        return deliveryTime;
    }

    @JsonProperty("DeliveryTime")
    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    @JsonProperty("IsFreeOrder")
    public Boolean getIsFreeOrder() {
        return isFreeOrder;
    }

    @JsonProperty("IsFreeOrder")
    public void setIsFreeOrder(Boolean isFreeOrder) {
        this.isFreeOrder = isFreeOrder;
    }

}
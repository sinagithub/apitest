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
        "MinimumDeliveryTotal",
        "DeliveryFee",
        "Total",
        "SubTotal",
        "VendorCategory",
        "VendorLogo",
        "TotalOriginal",
        "SubTotalOriginal",
        "DeliveryFeeOriginal",
        "TotalWithoutDeliveryFeeAndBag",
        "Saving"
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
    @JsonProperty("MinimumDeliveryTotal")
    private Double minimumDeliveryTotal;
    @JsonProperty("DeliveryFee")
    private Double deliveryFee;
    @JsonProperty("Total")
    private Double total;
    @JsonProperty("SubTotal")
    private Double subTotal;
    @JsonProperty("VendorCategory")
    private String vendorCategory;
    @JsonProperty("VendorLogo")
    private String vendorLogo;
    @JsonProperty("TotalOriginal")
    private Double totalOriginal;
    @JsonProperty("SubTotalOriginal")
    private Double subTotalOriginal;
    @JsonProperty("DeliveryFeeOriginal")
    private Double deliveryFeeOriginal;
    @JsonProperty("TotalWithoutDeliveryFeeAndBag")
    private Double totalWithoutDeliveryFeeAndBag;
    @JsonProperty("Saving")
    private Double saving;

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

    @JsonProperty("MinimumDeliveryTotal")
    public Double getMinimumDeliveryTotal() {
        return minimumDeliveryTotal;
    }

    @JsonProperty("MinimumDeliveryTotal")
    public void setMinimumDeliveryTotal(Double minimumDeliveryTotal) {
        this.minimumDeliveryTotal = minimumDeliveryTotal;
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

    @JsonProperty("SubTotal")
    public Double getSubTotal() {
        return subTotal;
    }

    @JsonProperty("SubTotal")
    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    @JsonProperty("VendorCategory")
    public String getVendorCategory() {
        return vendorCategory;
    }

    @JsonProperty("VendorCategory")
    public void setVendorCategory(String vendorCategory) {
        this.vendorCategory = vendorCategory;
    }

    @JsonProperty("VendorLogo")
    public String getVendorLogo() {
        return vendorLogo;
    }

    @JsonProperty("VendorLogo")
    public void setVendorLogo(String vendorLogo) {
        this.vendorLogo = vendorLogo;
    }

    @JsonProperty("TotalOriginal")
    public Double getTotalOriginal() {
        return totalOriginal;
    }

    @JsonProperty("TotalOriginal")
    public void setTotalOriginal(Double totalOriginal) {
        this.totalOriginal = totalOriginal;
    }

    @JsonProperty("SubTotalOriginal")
    public Double getSubTotalOriginal() {
        return subTotalOriginal;
    }

    @JsonProperty("SubTotalOriginal")
    public void setSubTotalOriginal(Double subTotalOriginal) {
        this.subTotalOriginal = subTotalOriginal;
    }

    @JsonProperty("DeliveryFeeOriginal")
    public Double getDeliveryFeeOriginal() {
        return deliveryFeeOriginal;
    }

    @JsonProperty("DeliveryFeeOriginal")
    public void setDeliveryFeeOriginal(Double deliveryFeeOriginal) {
        this.deliveryFeeOriginal = deliveryFeeOriginal;
    }

    @JsonProperty("TotalWithoutDeliveryFee")
    public Double getTotalWithoutDeliveryFeeAndBag() {
        return totalWithoutDeliveryFeeAndBag;
    }

    @JsonProperty("TotalWithoutDeliveryFee")
    public void setTotalWithoutDeliveryFeeAndBag(Double totalWithoutDeliveryFeeAndBag) {
        this.totalWithoutDeliveryFeeAndBag = totalWithoutDeliveryFeeAndBag;
    }

    @JsonProperty("Saving")
    public Double getSaving() {
        return saving;
    }

    @JsonProperty("Saving")
    public void setSaving(Double saving) {
        this.saving = saving;
    }

}
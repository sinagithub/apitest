package apiEngine.models.response.Basket;

import javax.annotation.Generated;
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
        "VendorLogo"
})
@Generated("jsonschema2pojo")
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
    private Integer minimumDeliveryTotal;
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

    /**
     * No args constructor for use in serialization
     *
     */
    public BasketInfo() {
    }

    /**
     *
     * @param basketId
     * @param total
     * @param deliveryFee
     * @param vendorCategory
     * @param basketStatus
     * @param vendorId
     * @param subTotal
     * @param isFreeOrder
     * @param vendorName
     * @param vendorLogo
     * @param minimumDeliveryTotal
     */
    public BasketInfo(String basketId, Integer basketStatus, Boolean isFreeOrder, String vendorId, String vendorName, Integer minimumDeliveryTotal, Double deliveryFee, Double total, Double subTotal, String vendorCategory, String vendorLogo) {
        super();
        this.basketId = basketId;
        this.basketStatus = basketStatus;
        this.isFreeOrder = isFreeOrder;
        this.vendorId = vendorId;
        this.vendorName = vendorName;
        this.minimumDeliveryTotal = minimumDeliveryTotal;
        this.deliveryFee = deliveryFee;
        this.total = total;
        this.subTotal = subTotal;
        this.vendorCategory = vendorCategory;
        this.vendorLogo = vendorLogo;
    }

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
    public Integer getMinimumDeliveryTotal() {
        return minimumDeliveryTotal;
    }

    @JsonProperty("MinimumDeliveryTotal")
    public void setMinimumDeliveryTotal(Integer minimumDeliveryTotal) {
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

}
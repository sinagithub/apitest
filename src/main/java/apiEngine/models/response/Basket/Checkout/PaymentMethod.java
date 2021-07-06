package apiEngine.models.response.Basket.Checkout;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Id",
        "PaymentType",
        "Rank",
        "CheckoutTypeId",
        "Name",
        "Description",
        "IconUrl",
        "IsSelected",
        "IsExpandable",
        "IsExpanded",
        "IsContactlessDeliveryAvailable",
        "SubMethods"
})

public class PaymentMethod {

    @JsonProperty("Id")
    private String id;
    @JsonProperty("PaymentType")
    private Integer paymentType;
    @JsonProperty("Rank")
    private Integer rank;
    @JsonProperty("CheckoutTypeId")
    private Integer checkoutTypeId;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("Description")
    private String description;
    @JsonProperty("IconUrl")
    private String iconUrl;
    @JsonProperty("IsSelected")
    private Boolean isSelected;
    @JsonProperty("IsExpandable")
    private Boolean isExpandable;
    @JsonProperty("IsExpanded")
    private Boolean isExpanded;
    @JsonProperty("IsContactlessDeliveryAvailable")
    private Boolean isContactlessDeliveryAvailable;
    @JsonProperty("SubMethods")
    private List<SubMethod> subMethods = null;

    @JsonProperty("Id")
    public String getId() {
        return id;
    }

    @JsonProperty("Id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("PaymentType")
    public Integer getPaymentType() {
        return paymentType;
    }

    @JsonProperty("PaymentType")
    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }

    @JsonProperty("Rank")
    public Integer getRank() {
        return rank;
    }

    @JsonProperty("Rank")
    public void setRank(Integer rank) {
        this.rank = rank;
    }

    @JsonProperty("CheckoutTypeId")
    public Integer getCheckoutTypeId() {
        return checkoutTypeId;
    }

    @JsonProperty("CheckoutTypeId")
    public void setCheckoutTypeId(Integer checkoutTypeId) {
        this.checkoutTypeId = checkoutTypeId;
    }

    @JsonProperty("Name")
    public String getName() {
        return name;
    }

    @JsonProperty("Name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("Description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("Description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("IconUrl")
    public String getIconUrl() {
        return iconUrl;
    }

    @JsonProperty("IconUrl")
    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    @JsonProperty("IsSelected")
    public Boolean getIsSelected() {
        return isSelected;
    }

    @JsonProperty("IsSelected")
    public void setIsSelected(Boolean isSelected) {
        this.isSelected = isSelected;
    }

    @JsonProperty("IsExpandable")
    public Boolean getIsExpandable() {
        return isExpandable;
    }

    @JsonProperty("IsExpandable")
    public void setIsExpandable(Boolean isExpandable) {
        this.isExpandable = isExpandable;
    }

    @JsonProperty("IsExpanded")
    public Boolean getIsExpanded() {
        return isExpanded;
    }

    @JsonProperty("IsExpanded")
    public void setIsExpanded(Boolean isExpanded) {
        this.isExpanded = isExpanded;
    }

    @JsonProperty("IsContactlessDeliveryAvailable")
    public Boolean getIsContactlessDeliveryAvailable() {
        return isContactlessDeliveryAvailable;
    }

    @JsonProperty("IsContactlessDeliveryAvailable")
    public void setIsContactlessDeliveryAvailable(Boolean isContactlessDeliveryAvailable) {
        this.isContactlessDeliveryAvailable = isContactlessDeliveryAvailable;
    }

    @JsonProperty("SubMethods")
    public List<SubMethod> getSubMethods() {
        return subMethods;
    }

    @JsonProperty("SubMethods")
    public void setSubMethods(List<SubMethod> subMethods) {
        this.subMethods = subMethods;
    }

}
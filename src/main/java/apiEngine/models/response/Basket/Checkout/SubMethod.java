package apiEngine.models.response.Basket.Checkout;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Id",
        "Name",
        "IconUrl",
        "Description",
        "BinNumber",
        "PointAmount",
        "IsSelected",
        "CheckoutTypeId",
        "PaymentType",
        "BankLogoUrl",
        "ParentId"
})

public class SubMethod {

    @JsonProperty("Id")
    private String id;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("IconUrl")
    private String iconUrl;
    @JsonProperty("Description")
    private String description;
    @JsonProperty("BinNumber")
    private Integer binNumber;
    @JsonProperty("PointAmount")
    private Integer pointAmount;
    @JsonProperty("IsSelected")
    private Boolean isSelected;
    @JsonProperty("CheckoutTypeId")
    private Integer checkoutTypeId;

    @JsonProperty("PaymentType")
    private Integer paymentType;
    @JsonProperty("ParentId")
    private String parentId;
    @JsonProperty("BankLogoUrl")
    private String bankLogoUrl;



    @JsonProperty("Id")
    public String getId() {
        return id;
    }

    @JsonProperty("Id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("Name")
    public String getName() {
        return name;
    }

    @JsonProperty("Name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("IconUrl")
    public String getIconUrl() {
        return iconUrl;
    }

    @JsonProperty("IconUrl")
    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    @JsonProperty("Description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("Description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("BinNumber")
    public Integer getBinNumber() {
        return binNumber;
    }

    @JsonProperty("BinNumber")
    public void setBinNumber(Integer binNumber) {
        this.binNumber = binNumber;
    }

    @JsonProperty("PointAmount")
    public Integer getPointAmount() {
        return pointAmount;
    }

    @JsonProperty("PointAmount")
    public void setPointAmount(Integer pointAmount) {
        this.pointAmount = pointAmount;
    }

    @JsonProperty("IsSelected")
    public Boolean getIsSelected() {
        return isSelected;
    }

    @JsonProperty("IsSelected")
    public void setIsSelected(Boolean isSelected) {
        this.isSelected = isSelected;
    }

    @JsonProperty("CheckoutTypeId")
    public Integer getCheckoutTypeId() {
        return checkoutTypeId;
    }

    @JsonProperty("CheckoutTypeId")
    public void setCheckoutTypeId(Integer checkoutTypeId) {
        this.checkoutTypeId = checkoutTypeId;
    }

    public Boolean getSelected() {
        return isSelected;
    }

    public void setSelected(Boolean selected) {
        isSelected = selected;
    }

    public Integer getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }

    @JsonProperty("BankLogoUrl")
    public String getBankLogoUrl() {
        return bankLogoUrl;
    }

    @JsonProperty("BankLogoUrl")
    public void setBankUrl(String bankLogoUrl) {
        this.bankLogoUrl = bankLogoUrl;
    }

    @JsonProperty("ParentId")
    public String parentId() {
        return parentId;
    }

    @JsonProperty("ParentId")
    public void parentId(String parentId) {
        this.parentId = bankLogoUrl;
    }
}

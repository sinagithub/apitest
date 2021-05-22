package apiEngine.models.response.Basket.Checkout;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Id",
        "Name",
        "ImageUrl",
        "Pan",
        "BinNumber",
        "PointAmount",
        "IsSelected",
        "CheckoutTypeId"
})
@Generated("jsonschema2pojo")
public class SubMethod {

    @JsonProperty("Id")
    private String id;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("ImageUrl")
    private String imageUrl;
    @JsonProperty("Pan")
    private String pan;
    @JsonProperty("BinNumber")
    private Integer binNumber;
    @JsonProperty("PointAmount")
    private Integer pointAmount;
    @JsonProperty("IsSelected")
    private Boolean isSelected;
    @JsonProperty("CheckoutTypeId")
    private Integer checkoutTypeId;

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

    @JsonProperty("ImageUrl")
    public String getImageUrl() {
        return imageUrl;
    }

    @JsonProperty("ImageUrl")
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @JsonProperty("Pan")
    public String getPan() {
        return pan;
    }

    @JsonProperty("Pan")
    public void setPan(String pan) {
        this.pan = pan;
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

}

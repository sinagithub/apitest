package apiEngine.models.requests.Basket.Checkout;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.cucumber.java.sl.In;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "PaymentMethodId",
        "PaymentType",
        "BinNumber",
        "IsApproved"
})
@Generated("jsonschema2pojo")
public class Payment {

    @JsonProperty("PaymentMethodId")
    private String paymentMethodId;
    @JsonProperty("PaymentType")
    private Integer paymentType;
    @JsonProperty("BinNumber")
    private Integer binNumber;
    @JsonProperty("IsApproved")
    private Boolean isApproved;

    /**
     * No args constructor for use in serialization
     *
     */
    public Payment() {
    }

    /**
     *
     * @param paymentType
     * @param paymentMethodId
     * @param binNumber
     * @param isApproved
     */
    public Payment(String paymentMethodId, Integer paymentType, Integer binNumber, Boolean isApproved) {
        super();
        this.paymentMethodId = paymentMethodId;
        this.paymentType = paymentType;
        this.binNumber = binNumber;
        this.isApproved = isApproved;
    }

    @JsonProperty("PaymentMethodId")
    public String getPaymentMethodId() {
        return paymentMethodId;
    }

    @JsonProperty("PaymentMethodId")
    public void setPaymentMethodId(String paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    @JsonProperty("PaymentType")
    public Integer getPaymentType() {
        return paymentType;
    }

    @JsonProperty("PaymentType")
    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }

    @JsonProperty("BinNumber")
    public Integer getBinNumber() {
        return binNumber;
    }

    @JsonProperty("BinNumber")
    public void setBinNumber(Integer binNumber) {
        this.binNumber = binNumber;
    }

    @JsonProperty("IsApproved")
    public Boolean getIsApproved() {
        return isApproved;
    }

    @JsonProperty("IsApproved")
    public void setIsApproved(Boolean isApproved) {
        this.isApproved = isApproved;
    }

}

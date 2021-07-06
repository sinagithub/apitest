package apiEngine.models.requests.Campaign;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Code",
        "PaymentMethodId",
        "UserHasOtpValidation"
})

public class ApplyCouponRequest {

    @JsonProperty("Code")
    private String code;
    @JsonProperty("PaymentMethodId")
    private String paymentMethodId;
    @JsonProperty("UserHasOtpValidation")
    private Boolean userHasOtpValidation;

    /**
     * No args constructor for use in serialization
     *
     */
    public ApplyCouponRequest() {
    }

    /**
     *
     * @param userHasOtpValidation
     * @param code
     * @param paymentMethodId
     */
    public ApplyCouponRequest(String code, String paymentMethodId, Boolean userHasOtpValidation) {
        super();
        this.code = code;
        this.paymentMethodId = paymentMethodId;
        this.userHasOtpValidation = userHasOtpValidation;
    }

    @JsonProperty("Code")
    public String getCode() {
        return code;
    }

    @JsonProperty("Code")
    public void setCode(String code) {
        this.code = code;
    }

    @JsonProperty("PaymentMethodId")
    public String getPaymentMethodId() {
        return paymentMethodId;
    }

    @JsonProperty("PaymentMethodId")
    public void setPaymentMethodId(String paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    @JsonProperty("UserHasOtpValidation")
    public Boolean getUserHasOtpValidation() {
        return userHasOtpValidation;
    }

    @JsonProperty("UserHasOtpValidation")
    public void setUserHasOtpValidation(Boolean userHasOtpValidation) {
        this.userHasOtpValidation = userHasOtpValidation;
    }

}
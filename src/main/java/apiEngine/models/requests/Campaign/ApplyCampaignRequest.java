package apiEngine.models.requests.Campaign;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "CampaignId",
        "CouponCode",
        "UserHasOtpValidation"
})
@Generated("jsonschema2pojo")
public class ApplyCampaignRequest {

    @JsonProperty("CampaignId")
    private String campaignId;
    @JsonProperty("CouponCode")
    private String couponCode;
    @JsonProperty("UserHasOtpValidation")
    private Boolean userHasOtpValidation;

    /**
     * No args constructor for use in serialization
     *
     */
    public ApplyCampaignRequest() {
    }

    /**
     *
     * @param userHasOtpValidation
     * @param campaignId
     * @param couponCode
     */
    public ApplyCampaignRequest(String campaignId, String couponCode, Boolean userHasOtpValidation) {
        super();
        this.campaignId = campaignId;
        this.couponCode = couponCode;
        this.userHasOtpValidation = userHasOtpValidation;
    }

    @JsonProperty("CampaignId")
    public String getCampaignId() {
        return campaignId;
    }

    @JsonProperty("CampaignId")
    public void setCampaignId(String campaignId) {
        this.campaignId = campaignId;
    }

    @JsonProperty("CouponCode")
    public String getCouponCode() {
        return couponCode;
    }

    @JsonProperty("CouponCode")
    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
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

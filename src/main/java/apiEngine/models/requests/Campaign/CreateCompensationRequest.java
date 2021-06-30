package apiEngine.models.requests.Campaign;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "CampaignId",
        "UserId",
        "EndDate"
})
@Generated("jsonschema2pojo")
public class CreateCompensationRequest {

    @JsonProperty("CampaignId")
    private String campaignId;
    @JsonProperty("UserId")
    private String userId;
    @JsonProperty("EndDate")
    private String endDate;

    /**
     * No args constructor for use in serialization
     *
     */
    public CreateCompensationRequest() {
    }

    /**
     *
     * @param endDate
     * @param campaignId
     * @param userId
     */
    public CreateCompensationRequest(String campaignId, String userId, String endDate) {
        super();
        this.campaignId = campaignId;
        this.userId = userId;
        this.endDate = endDate;
    }

    @JsonProperty("CampaignId")
    public String getCampaignId() {
        return campaignId;
    }

    @JsonProperty("CampaignId")
    public void setCampaignId(String campaignId) {
        this.campaignId = campaignId;
    }

    @JsonProperty("UserId")
    public String getUserId() {
        return userId;
    }

    @JsonProperty("UserId")
    public void setUserId(String userId) {
        this.userId = userId;
    }

    @JsonProperty("EndDate")
    public String getEndDate() {
        return endDate;
    }

    @JsonProperty("EndDate")
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

}
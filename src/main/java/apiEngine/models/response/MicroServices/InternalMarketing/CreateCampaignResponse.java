package apiEngine.models.response.MicroServices.InternalMarketing;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "CampaignId"
})

public class CreateCampaignResponse {

    @JsonProperty("CampaignId")
    private String campaignId;

    /**
     * No args constructor for use in serialization
     *
     */
    public CreateCampaignResponse() {
    }

    /**
     *
     * @param campaignId
     */
    public CreateCampaignResponse(String campaignId) {
        super();
        this.campaignId = campaignId;
    }

    @JsonProperty("CampaignId")
    public String getCampaignId() {
        return campaignId;
    }

    @JsonProperty("CampaignId")
    public void setCampaignId(String campaignId) {
        this.campaignId = campaignId;
    }

}
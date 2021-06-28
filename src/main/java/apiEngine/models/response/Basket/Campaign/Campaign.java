package apiEngine.models.response.Basket.Campaign;


import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "CampaignItem"
})
@Generated("jsonschema2pojo")
public class Campaign {

    @JsonProperty("CampaignItem")
    private CampaignItem campaignItem;

    /**
     * No args constructor for use in serialization
     *
     */
    public Campaign() {
    }

    /**
     *
     * @param campaignItem
     */
    public Campaign(CampaignItem campaignItem) {
        super();
        this.campaignItem = campaignItem;
    }

    @JsonProperty("CampaignItem")
    public CampaignItem getCampaignItem() {
        return campaignItem;
    }

    @JsonProperty("CampaignItem")
    public void setCampaignItem(CampaignItem campaignItem) {
        this.campaignItem = campaignItem;
    }

}
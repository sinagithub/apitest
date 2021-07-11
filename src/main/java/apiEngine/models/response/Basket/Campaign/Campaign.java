package apiEngine.models.response.Basket.Campaign;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonPropertyOrder({
        "BasketLineSourceId",
        "BasketLineTargetIds",
        "CampaignItem"
})

public class Campaign {

    @JsonProperty("BasketLineSourceId")
    private String basketLineSourceId;
    @JsonProperty("BasketLineTargetIds")
    private List<String> basketLineTargetIds = null;
    @JsonProperty("CampaignItem")
    private CampaignItem campaignItem;

    @JsonProperty("BasketLineSourceId")
    public String getBasketLineSourceId() {
        return basketLineSourceId;
    }

    @JsonProperty("BasketLineSourceId")
    public void setBasketLineSourceId(String basketLineSourceId) {
        this.basketLineSourceId = basketLineSourceId;
    }

    @JsonProperty("BasketLineTargetIds")
    public List<String> getBasketLineTargetIds() {
        return basketLineTargetIds;
    }

    @JsonProperty("BasketLineTargetIds")
    public void setBasketLineTargetIds(List<String> basketLineTargetIds) {
        this.basketLineTargetIds = basketLineTargetIds;
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
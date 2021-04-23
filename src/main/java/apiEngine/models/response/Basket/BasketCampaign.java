package apiEngine.models.response.Basket;

import java.util.List;

import apiEngine.models.response.Basket.CampaignItem;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "BasketLineSourceId",
        "BasketLineTargetIds",
        "CampaignItems"
})
public class BasketCampaign {

    @JsonProperty("BasketLineSourceId")
    private String basketLineSourceId;
    @JsonProperty("BasketLineTargetIds")
    private List<String> basketLineTargetIds = null;
    @JsonProperty("CampaignItems")
    private List<CampaignItem> campaignItems = null;

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

    @JsonProperty("CampaignItems")
    public List<CampaignItem> getCampaignItems() {
        return campaignItems;
    }

    @JsonProperty("CampaignItems")
    public void setCampaignItems(List<CampaignItem> campaignItems) {
        this.campaignItems = campaignItems;
    }

}

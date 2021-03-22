package apiEngine.models.response.Basket.Campaign;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Available",
        "Unavailable"
})
public class CampaignData {

    @JsonProperty("Available")
    private List<AvailableCampaigns> availableCampaigns = null;
    @JsonProperty("Unavailable")
    private List<UnavailableCampaigns> unavailableCampaigns = null;

    @JsonProperty("Available")
    public List<AvailableCampaigns> getAvailable() {
        return availableCampaigns;
    }

    @JsonProperty("Available")
    public void setAvailable(List<AvailableCampaigns> availableCampaigns) {
        this.availableCampaigns = availableCampaigns;
    }

    @JsonProperty("Unavailable")
    public List<UnavailableCampaigns> getUnavailable() {
        return unavailableCampaigns;
    }

    @JsonProperty("Unavailable")
    public void setUnavailable(List<UnavailableCampaigns> unavailableCampaigns) {
        this.unavailableCampaigns = unavailableCampaigns;
    }

}

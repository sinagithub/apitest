package apiEngine.models.response.Campaign;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "CouponCampaigns",
        "Campaigns"
})

public class VendorCampaignData {

    @JsonProperty("CouponCampaigns")
    private List<CouponCampaign> couponCampaigns = null;
    @JsonProperty("Campaigns")
    private List<Campaign> campaigns = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("CouponCampaigns")
    public List<CouponCampaign> getCouponCampaigns() {
        return couponCampaigns;
    }

    @JsonProperty("CouponCampaigns")
    public void setCouponCampaigns(List<CouponCampaign> couponCampaigns) {
        this.couponCampaigns = couponCampaigns;
    }

    @JsonProperty("Campaigns")
    public List<Campaign> getCampaigns() {
        return campaigns;
    }

    @JsonProperty("Campaigns")
    public void setCampaigns(List<Campaign> campaigns) {
        this.campaigns = campaigns;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
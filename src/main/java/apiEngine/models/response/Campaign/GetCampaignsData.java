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
        "GeneralCampaigns",
        "VendorCampaigns"
})

public class GetCampaignsData {

    @JsonProperty("CouponCampaigns")
    private List<CouponCampaign> couponCampaigns = null;
    @JsonProperty("GeneralCampaigns")
    private List<GeneralCampaign> generalCampaigns = null;
    @JsonProperty("VendorCampaigns")
    private List<VendorCampaign> vendorCampaigns = null;
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

    @JsonProperty("GeneralCampaigns")
    public List<GeneralCampaign> getGeneralCampaigns() {
        return generalCampaigns;
    }

    @JsonProperty("GeneralCampaigns")
    public void setGeneralCampaigns(List<GeneralCampaign> generalCampaigns) {
        this.generalCampaigns = generalCampaigns;
    }

    @JsonProperty("VendorCampaigns")
    public List<VendorCampaign> getVendorCampaigns() {
        return vendorCampaigns;
    }

    @JsonProperty("VendorCampaigns")
    public void setVendorCampaigns(List<VendorCampaign> vendorCampaigns) {
        this.vendorCampaigns = vendorCampaigns;
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
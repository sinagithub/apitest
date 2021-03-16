package apiEngine.models.response.Splash;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class SplashData {
    @JsonProperty("IsCarsiEnabled")
    private Boolean isCarsiEnabled;
    @JsonProperty("Campaigns")
    private List<CampaignsItem> campaigns = null;
    @JsonProperty("CarsiLogoUrl")
    private String carsiLogoUrl;

    @JsonProperty("IsCarsiEnabled")
    public Boolean getIsCarsiEnabled() {
        return isCarsiEnabled;
    }

    @JsonProperty("IsCarsiEnabled")
    public void setIsCarsiEnabled(Boolean isCarsiEnabled) {
        this.isCarsiEnabled = isCarsiEnabled;
    }

    @JsonProperty("Campaigns")
    public List<CampaignsItem> getCampaigns() {
        return campaigns;
    }

    @JsonProperty("Campaigns")
    public void setCampaigns(List<CampaignsItem> campaigns) {
        this.campaigns = campaigns;
    }

    @JsonProperty("CarsiLogoUrl")
    public String getCarsiLogoUrl() {
        return carsiLogoUrl;
    }

    @JsonProperty("CarsiLogoUrl")
    public void setCarsiLogoUrl(String carsiLogoUrl) {
        this.carsiLogoUrl = carsiLogoUrl;
    }
}
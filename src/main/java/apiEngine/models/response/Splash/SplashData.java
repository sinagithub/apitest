package apiEngine.models.response.Splash;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class SplashData {
    @JsonProperty("IsMahalleEnabled")
    private Boolean isMahalleEnabled;
    @JsonProperty("Campaigns")
    private List<CampaignsItem> campaigns = null;
    @JsonProperty("CarsiLogoUrl")
    private String carsiLogoUrl;

    @JsonProperty("IsMahalleEnabled")
    public Boolean getIsMahalleEnabled() {
        return isMahalleEnabled;
    }

    @JsonProperty("IsCarsiEnabled")
    public void setIsMahalleEnabled(Boolean isMahalleEnabled) {
        this.isMahalleEnabled = isMahalleEnabled;
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
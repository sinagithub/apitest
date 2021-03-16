package apiEngine.models.response.Splash;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CampaignsItem{

	@JsonProperty("CampaignId")
	private Integer campaignId;
	@JsonProperty("CampaignThumbImageUrl")
	private String campaignThumbImageUrl;
	@JsonProperty("SeoUrl")
	private String seoUrl;

	@JsonProperty("CampaignId")
	public Integer getCampaignId() {
		return campaignId;
	}

	@JsonProperty("CampaignId")
	public void setCampaignId(Integer campaignId) {
		this.campaignId = campaignId;
	}

	@JsonProperty("CampaignThumbImageUrl")
	public String getCampaignThumbImageUrl() {
		return campaignThumbImageUrl;
	}

	@JsonProperty("CampaignThumbImageUrl")
	public void setCampaignThumbImageUrl(String campaignThumbImageUrl) {
		this.campaignThumbImageUrl = campaignThumbImageUrl;
	}

	@JsonProperty("SeoUrl")
	public String getSeoUrl() {
		return seoUrl;
	}

	@JsonProperty("SeoUrl")
	public void setSeoUrl(String seoUrl) {
		this.seoUrl = seoUrl;
	}

}

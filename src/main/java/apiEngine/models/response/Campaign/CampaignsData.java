package apiEngine.models.response.Campaign;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "ImageUrl",
        "CampaignTitle",
        "Description"
})

public class CampaignsData {

    @JsonProperty("ImageUrl")
    private String imageUrl;
    @JsonProperty("CampaignTitle")
    private String campaignTitle;
    @JsonProperty("Description")
    private String description;

    /**
     * No args constructor for use in serialization
     *
     */
    public CampaignsData() {
    }

    /**
     *
     * @param campaignTitle
     * @param imageUrl
     * @param description
     */
    public CampaignsData(String imageUrl, String campaignTitle, String description) {
        super();
        this.imageUrl = imageUrl;
        this.campaignTitle = campaignTitle;
        this.description = description;
    }

    @JsonProperty("ImageUrl")
    public String getImageUrl() {
        return imageUrl;
    }

    @JsonProperty("ImageUrl")
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @JsonProperty("CampaignTitle")
    public String getCampaignTitle() {
        return campaignTitle;
    }

    @JsonProperty("CampaignTitle")
    public void setCampaignTitle(String campaignTitle) {
        this.campaignTitle = campaignTitle;
    }

    @JsonProperty("Description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("Description")
    public void setDescription(String description) {
        this.description = description;
    }

}

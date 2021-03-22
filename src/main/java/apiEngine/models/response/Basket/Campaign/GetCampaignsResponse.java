package apiEngine.models.response.Basket.Campaign;

import java.util.List;

import apiEngine.models.response.InfoList;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Version",
        "InfoList",
        "Data"
})
public class GetCampaignsResponse {

    @JsonProperty("Version")
    private String version;
    @JsonProperty("InfoList")
    private List<InfoList> infoList = null;
    @JsonProperty("Data")
    private CampaignData campaignData;

    @JsonProperty("Version")
    public String getVersion() {
        return version;
    }

    @JsonProperty("Version")
    public void setVersion(String version) {
        this.version = version;
    }

    @JsonProperty("InfoList")
    public List<InfoList> getInfoList() {
        return infoList;
    }

    @JsonProperty("InfoList")
    public void setInfoList(List<InfoList> infoList) {
        this.infoList = infoList;
    }

    @JsonProperty("Data")
    public CampaignData getData() {
        return campaignData;
    }

    @JsonProperty("Data")
    public void setData(CampaignData campaignData) {
        this.campaignData = campaignData;
    }

}

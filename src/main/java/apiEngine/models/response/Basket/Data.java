package apiEngine.models.response.Basket;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "TotalCampaignCount",
        "BasketInfo",
        "Lines",
        "Campaigns",
        "ValidationInfo",
        "BasketVolume"
})

public class Data {

    @JsonProperty("TotalCampaignCount")
    private Integer totalCampaignCount;
    @JsonProperty("BasketInfo")
    private BasketInfo basketInfo;
    @JsonProperty("Lines")
    private List<BasketLine> lines = null;
    @JsonProperty("Campaigns")
    private List<Object> campaigns = null;
    @JsonProperty("ValidationInfo")
    private ValidationInfo validationInfo;
    @JsonProperty("BasketVolume")
    private Integer basketVolume;

    @JsonProperty("TotalCampaignCount")
    public Integer getTotalCampaignCount() {
        return totalCampaignCount;
    }

    @JsonProperty("TotalCampaignCount")
    public void setTotalCampaignCount(Integer totalCampaignCount) {
        this.totalCampaignCount = totalCampaignCount;
    }

    @JsonProperty("BasketInfo")
    public BasketInfo getBasketInfo() {
        return basketInfo;
    }

    @JsonProperty("BasketInfo")
    public void setBasketInfo(BasketInfo basketInfo) {
        this.basketInfo = basketInfo;
    }

    @JsonProperty("Lines")
    public List<BasketLine> getLines() {
        return lines;
    }

    @JsonProperty("Lines")
    public void setLines(List<BasketLine> lines) {
        this.lines = lines;
    }

    @JsonProperty("Campaigns")
    public List<Object> getCampaigns() {
        return campaigns;
    }

    @JsonProperty("Campaigns")
    public void setCampaigns(List<Object> campaigns) {
        this.campaigns = campaigns;
    }

    @JsonProperty("ValidationInfo")
    public ValidationInfo getValidationInfo() {
        return validationInfo;
    }

    @JsonProperty("ValidationInfo")
    public void setValidationInfo(ValidationInfo validationInfo) {
        this.validationInfo = validationInfo;
    }

    @JsonProperty("BasketVolume")
    public Integer getBasketVolume() {
        return basketVolume;
    }

    @JsonProperty("BasketVolume")
    public void setBasketVolume(Integer basketVolume) {
        this.basketVolume = basketVolume;
    }

}

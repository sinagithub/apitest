package apiEngine.models.response.MicroServices.InternalMarketing;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Campaigns",
        "TotalCount",
        "TotalPageCount"
})

public class GetCampaignsResponse {

    @JsonProperty("Campaigns")
    private List<InternalCampaign> campaigns = null;
    @JsonProperty("TotalCount")
    private Integer totalCount;
    @JsonProperty("TotalPageCount")
    private Integer totalPageCount;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Campaigns")
    public List<InternalCampaign> getCampaigns() {
        return campaigns;
    }

    @JsonProperty("Campaigns")
    public void setCampaigns(List<InternalCampaign> campaigns) {
        this.campaigns = campaigns;
    }

    @JsonProperty("TotalCount")
    public Integer getTotalCount() {
        return totalCount;
    }

    @JsonProperty("TotalCount")
    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    @JsonProperty("TotalPageCount")
    public Integer getTotalPageCount() {
        return totalPageCount;
    }

    @JsonProperty("TotalPageCount")
    public void setTotalPageCount(Integer totalPageCount) {
        this.totalPageCount = totalPageCount;
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

package apiEngine.models.response.Campaign;

import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Data",
        "InfoList"
})
@Generated("jsonschema2pojo")
public class CampaignCouponsResponse {

    @JsonProperty("Data")
    private List<CampaignsData> data = null;
    @JsonProperty("InfoList")
    private List<Object> infoList = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public CampaignCouponsResponse() {
    }

    /**
     *
     * @param data
     * @param infoList
     */
    public CampaignCouponsResponse(List<CampaignsData> data, List<Object> infoList) {
        super();
        this.data = data;
        this.infoList = infoList;
    }

    @JsonProperty("Data")
    public List<CampaignsData> getData() {
        return data;
    }

    @JsonProperty("Data")
    public void setData(List<CampaignsData> data) {
        this.data = data;
    }

    @JsonProperty("InfoList")
    public List<Object> getInfoList() {
        return infoList;
    }

    @JsonProperty("InfoList")
    public void setInfoList(List<Object> infoList) {
        this.infoList = infoList;
    }

}

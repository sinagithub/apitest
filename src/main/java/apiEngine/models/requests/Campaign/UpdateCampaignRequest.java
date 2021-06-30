package apiEngine.models.requests.Campaign;


import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Status",
        "StartDate",
        "EndDate"
})
@Generated("jsonschema2pojo")
public class UpdateCampaignRequest {

    @JsonProperty("Status")
    private Integer status;
    @JsonProperty("StartDate")
    private String startDate;
    @JsonProperty("EndDate")
    private String endDate;

    /**
     * No args constructor for use in serialization
     *
     */
    public UpdateCampaignRequest() {
    }

    /**
     *
     * @param endDate
     * @param startDate
     * @param status
     */
    public UpdateCampaignRequest(Integer status, String startDate, String endDate) {
        super();
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @JsonProperty("Status")
    public Integer getStatus() {
        return status;
    }

    @JsonProperty("Status")
    public void setStatus(Integer status) {
        this.status = status;
    }

    @JsonProperty("StartDate")
    public String getStartDate() {
        return startDate;
    }

    @JsonProperty("StartDate")
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    @JsonProperty("EndDate")
    public String getEndDate() {
        return endDate;
    }

    @JsonProperty("EndDate")
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

}
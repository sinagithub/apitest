package apiEngine.models.response.MicroServices.InternalMarketing;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Id",
        "Code",
        "UsageLimit",
        "UsedCount",
        "IsUsable",
        "Status"
})

public class CampaignCouponResponse {

    @JsonProperty("Id")
    private String id;
    @JsonProperty("Code")
    private String code;
    @JsonProperty("UsageLimit")
    private Integer usageLimit;
    @JsonProperty("UsedCount")
    private Integer usedCount;
    @JsonProperty("IsUsable")
    private Boolean isUsable;
    @JsonProperty("Status")
    private Integer status;

    @JsonProperty("Id")
    public String getId() {
        return id;
    }

    @JsonProperty("Id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("Code")
    public String getCode() {
        return code;
    }

    @JsonProperty("Code")
    public void setCode(String code) {
        this.code = code;
    }

    @JsonProperty("UsageLimit")
    public Integer getUsageLimit() {
        return usageLimit;
    }

    @JsonProperty("UsageLimit")
    public void setUsageLimit(Integer usageLimit) {
        this.usageLimit = usageLimit;
    }

    @JsonProperty("UsedCount")
    public Integer getUsedCount() {
        return usedCount;
    }

    @JsonProperty("UsedCount")
    public void setUsedCount(Integer usedCount) {
        this.usedCount = usedCount;
    }

    @JsonProperty("IsUsable")
    public Boolean getIsUsable() {
        return isUsable;
    }

    @JsonProperty("IsUsable")
    public void setIsUsable(Boolean isUsable) {
        this.isUsable = isUsable;
    }

    @JsonProperty("Status")
    public Integer getStatus() {
        return status;
    }

    @JsonProperty("Status")
    public void setStatus(Integer status) {
        this.status = status;
    }

}
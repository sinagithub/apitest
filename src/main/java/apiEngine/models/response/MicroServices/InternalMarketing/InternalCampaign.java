package apiEngine.models.response.MicroServices.InternalMarketing;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Id",
        "Name",
        "IsCouponRequired",
        "IsShownOnCheckout",
        "IsShownOnHomepage",
        "StartDate",
        "EndDate",
        "CreatedDate",
        "CreatedBy",
        "Status"
})

public class InternalCampaign {

    @JsonProperty("Id")
    private String id;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("IsCouponRequired")
    private Boolean isCouponRequired;
    @JsonProperty("IsShownOnCheckout")
    private Boolean isShownOnCheckout;
    @JsonProperty("IsShownOnHomepage")
    private Boolean isShownOnHomepage;
    @JsonProperty("StartDate")
    private String startDate;
    @JsonProperty("EndDate")
    private String endDate;
    @JsonProperty("CreatedDate")
    private String createdDate;
    @JsonProperty("CreatedBy")
    private String createdBy;
    @JsonProperty("Status")
    private Integer status;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Id")
    public String getId() {
        return id;
    }

    @JsonProperty("Id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("Name")
    public String getName() {
        return name;
    }

    @JsonProperty("Name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("IsCouponRequired")
    public Boolean getIsCouponRequired() {
        return isCouponRequired;
    }

    @JsonProperty("IsCouponRequired")
    public void setIsCouponRequired(Boolean isCouponRequired) {
        this.isCouponRequired = isCouponRequired;
    }

    @JsonProperty("IsShownOnCheckout")
    public Boolean getIsShownOnCheckout() {
        return isShownOnCheckout;
    }

    @JsonProperty("IsShownOnCheckout")
    public void setIsShownOnCheckout(Boolean isShownOnCheckout) {
        this.isShownOnCheckout = isShownOnCheckout;
    }

    @JsonProperty("IsShownOnHomepage")
    public Boolean getIsShownOnHomepage() {
        return isShownOnHomepage;
    }

    @JsonProperty("IsShownOnHomepage")
    public void setIsShownOnHomepage(Boolean isShownOnHomepage) {
        this.isShownOnHomepage = isShownOnHomepage;
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

    @JsonProperty("CreatedDate")
    public String getCreatedDate() {
        return createdDate;
    }

    @JsonProperty("CreatedDate")
    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    @JsonProperty("CreatedBy")
    public String getCreatedBy() {
        return createdBy;
    }

    @JsonProperty("CreatedBy")
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @JsonProperty("Status")
    public Integer getStatus() {
        return status;
    }

    @JsonProperty("Status")
    public void setStatus(Integer status) {
        this.status = status;
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
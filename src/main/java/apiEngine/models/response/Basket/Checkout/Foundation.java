package apiEngine.models.response.Basket.Checkout;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "FoundationId",
        "FoundationName",
        "FoundationDescription",
        "FoundationIconUrl",
        "IsActive",
        "IsSelected",
        "Rank"
})
@Generated("jsonschema2pojo")
public class Foundation {

    @JsonProperty("FoundationId")
    private String foundationId;
    @JsonProperty("FoundationName")
    private String foundationName;
    @JsonProperty("FoundationDescription")
    private String foundationDescription;
    @JsonProperty("FoundationIconUrl")
    private String foundationIconUrl;
    @JsonProperty("IsActive")
    private Boolean isActive;
    @JsonProperty("IsSelected")
    private Boolean isSelected;
    @JsonProperty("Rank")
    private Integer rank;

    @JsonProperty("FoundationId")
    public String getFoundationId() {
        return foundationId;
    }

    @JsonProperty("FoundationId")
    public void setFoundationId(String foundationId) {
        this.foundationId = foundationId;
    }

    @JsonProperty("FoundationName")
    public String getFoundationName() {
        return foundationName;
    }

    @JsonProperty("FoundationName")
    public void setFoundationName(String foundationName) {
        this.foundationName = foundationName;
    }

    @JsonProperty("FoundationDescription")
    public String getFoundationDescription() {
        return foundationDescription;
    }

    @JsonProperty("FoundationDescription")
    public void setFoundationDescription(String foundationDescription) {
        this.foundationDescription = foundationDescription;
    }

    @JsonProperty("FoundationIconUrl")
    public String getFoundationIconUrl() {
        return foundationIconUrl;
    }

    @JsonProperty("FoundationIconUrl")
    public void setFoundationIconUrl(String foundationIconUrl) {
        this.foundationIconUrl = foundationIconUrl;
    }

    @JsonProperty("IsActive")
    public Boolean getIsActive() {
        return isActive;
    }

    @JsonProperty("IsActive")
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    @JsonProperty("IsSelected")
    public Boolean getIsSelected() {
        return isSelected;
    }

    @JsonProperty("IsSelected")
    public void setIsSelected(Boolean isSelected) {
        this.isSelected = isSelected;
    }

    @JsonProperty("Rank")
    public Integer getRank() {
        return rank;
    }

    @JsonProperty("Rank")
    public void setRank(Integer rank) {
        this.rank = rank;
    }

}

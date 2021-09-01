package apiEngine.models.response.Basket.Checkout;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "FoundationId",
        "FoundationName",
        "FoundationDescription",
        "FoundationIconUrl",
        "IsActive"
})

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

}
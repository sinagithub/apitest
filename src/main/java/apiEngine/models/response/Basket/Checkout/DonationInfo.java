package apiEngine.models.response.Basket.Checkout;

import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Foundations",
        "Enabled",
        "Options"
})
@Generated("jsonschema2pojo")
public class DonationInfo {

    @JsonProperty("Foundations")
    private List<Foundation> foundations = null;
    @JsonProperty("Enabled")
    private Boolean enabled;
    @JsonProperty("Options")
    private List<Option> options = null;

    @JsonProperty("Foundations")
    public List<Foundation> getFoundations() {
        return foundations;
    }

    @JsonProperty("Foundations")
    public void setFoundations(List<Foundation> foundations) {
        this.foundations = foundations;
    }

    @JsonProperty("Enabled")
    public Boolean getEnabled() {
        return enabled;
    }

    @JsonProperty("Enabled")
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @JsonProperty("Options")
    public List<Option> getOptions() {
        return options;
    }

}

package apiEngine.models.response.Basket.Checkout.PutCheckout;


import java.util.List;


import apiEngine.models.response.Basket.Checkout.Option;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Enabled",
        "Options"
})

public class DonationInfo {

    @JsonProperty("Enabled")
    private Boolean enabled;
    @JsonProperty("Options")
    private List<Option> options = null;

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

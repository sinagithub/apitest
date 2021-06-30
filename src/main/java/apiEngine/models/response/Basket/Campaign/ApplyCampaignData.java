package apiEngine.models.response.Basket.Campaign;

import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Available",
        "Unavailable"
})
@Generated("jsonschema2pojo")
public class ApplyCampaignData {

    @JsonProperty("Available")
    private List<Available> available = null;
    @JsonProperty("Unavailable")
    private List<Unavailable> unavailable = null;

    @JsonProperty("Available")
    public List<Available> getAvailable() {
        return available;
    }

    @JsonProperty("Available")
    public void setAvailable(List<Available> available) {
        this.available = available;
    }

    @JsonProperty("Unavailable")
    public List<Unavailable> getUnavailable() {
        return unavailable;
    }

    @JsonProperty("Unavailable")
    public void setUnavailable(List<Unavailable> unavailable) {
        this.unavailable = unavailable;
    }

}

package apiEngine.models.response.Basket;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
        "AlternateOptions"
})

public class AlternateOptionData {

    @JsonProperty("AlternateOptions")
    private List<AlternateOption> alternateOptions = null;

    @JsonProperty("AlternateOptions")
    public List<AlternateOption> getAlternateOptions() {
        return alternateOptions;
    }

    @JsonProperty("AlternateOptions")
    public void setAlternateOptions(List<AlternateOption> alternateOptions) {
        this.alternateOptions = alternateOptions;
    }

}
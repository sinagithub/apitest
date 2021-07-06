package apiEngine.models.response.MicroServices.InternalVendor;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "StartHour",
        "EndHour",
        "IsCurrentSpan"
})

public class Slot {

    @JsonProperty("StartHour")
    private String startHour;
    @JsonProperty("EndHour")
    private String endHour;
    @JsonProperty("IsCurrentSpan")
    private Boolean isCurrentSpan;

    @JsonProperty("StartHour")
    public String getStartHour() {
        return startHour;
    }

    @JsonProperty("StartHour")
    public void setStartHour(String startHour) {
        this.startHour = startHour;
    }

    @JsonProperty("EndHour")
    public String getEndHour() {
        return endHour;
    }

    @JsonProperty("EndHour")
    public void setEndHour(String endHour) {
        this.endHour = endHour;
    }

    @JsonProperty("IsCurrentSpan")
    public Boolean getIsCurrentSpan() {
        return isCurrentSpan;
    }

    @JsonProperty("IsCurrentSpan")
    public void setIsCurrentSpan(Boolean isCurrentSpan) {
        this.isCurrentSpan = isCurrentSpan;
    }

}
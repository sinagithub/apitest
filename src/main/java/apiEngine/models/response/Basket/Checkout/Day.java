package apiEngine.models.response.Basket.Checkout;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Day",
        "DateText",
        "IsEnabled",
        "Hours"
})

public class Day {

    @JsonProperty("Day")
    private String day;
    @JsonProperty("DateText")
    private String dateText;
    @JsonProperty("IsEnabled")
    private Boolean isEnabled;
    @JsonProperty("Hours")
    private List<Hour> hours = null;

    @JsonProperty("Day")
    public String getDay() {
        return day;
    }

    @JsonProperty("Day")
    public void setDay(String day) {
        this.day = day;
    }

    @JsonProperty("DateText")
    public String getDateText() {
        return dateText;
    }

    @JsonProperty("DateText")
    public void setDateText(String dateText) {
        this.dateText = dateText;
    }

    @JsonProperty("IsEnabled")
    public Boolean getIsEnabled() {
        return isEnabled;
    }

    @JsonProperty("IsEnabled")
    public void setIsEnabled(Boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    @JsonProperty("Hours")
    public List<Hour> getHours() {
        return hours;
    }

    @JsonProperty("Hours")
    public void setHours(List<Hour> hours) {
        this.hours = hours;
    }

}

package apiEngine.models.response.Basket.Checkout;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Day",
        "DateText",
        "IsEnabled",
        "IsOutOfService",
        "IsSelected",
        "Hours"
})
@Generated("jsonschema2pojo")
public class Day {

    @JsonProperty("Day")
    private String day;
    @JsonProperty("DateText")
    private String dateText;
    @JsonProperty("IsEnabled")
    private Boolean isEnabled;
    @JsonProperty("IsOutOfService")
    private Boolean isOutOfService;
    @JsonProperty("IsSelected")
    private Boolean isSelected;
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

    @JsonProperty("IsOutOfService")
    public Boolean getIsOutOfService() {
        return isOutOfService;
    }

    @JsonProperty("IsOutOfService")
    public void setIsOutOfService(Boolean isOutOfService) {
        this.isOutOfService = isOutOfService;
    }

    @JsonProperty("IsSelected")
    public Boolean getIsSelected() {
        return isSelected;
    }

    @JsonProperty("IsSelected")
    public void setIsSelected(Boolean isSelected) {
        this.isSelected = isSelected;
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
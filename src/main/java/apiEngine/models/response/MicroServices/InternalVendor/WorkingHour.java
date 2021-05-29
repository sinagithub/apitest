package apiEngine.models.response.MicroServices.InternalVendor;

import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "DayOfWeek",
        "DayName",
        "StartHour",
        "EndHour",
        "IsCurrentSpan",
        "Slots"
})
@Generated("jsonschema2pojo")
public class WorkingHour {

    @JsonProperty("DayOfWeek")
    private Integer dayOfWeek;
    @JsonProperty("DayName")
    private String dayName;
    @JsonProperty("StartHour")
    private String startHour;
    @JsonProperty("EndHour")
    private String endHour;
    @JsonProperty("IsCurrentSpan")
    private Boolean isCurrentSpan;
    @JsonProperty("Slots")
    private List<Slot> slots = null;

    @JsonProperty("DayOfWeek")
    public Integer getDayOfWeek() {
        return dayOfWeek;
    }

    @JsonProperty("DayOfWeek")
    public void setDayOfWeek(Integer dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    @JsonProperty("DayName")
    public String getDayName() {
        return dayName;
    }

    @JsonProperty("DayName")
    public void setDayName(String dayName) {
        this.dayName = dayName;
    }

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

    @JsonProperty("Slots")
    public List<Slot> getSlots() {
        return slots;
    }

    @JsonProperty("Slots")
    public void setSlots(List<Slot> slots) {
        this.slots = slots;
    }

}
package apiEngine.models.requests.InternalVendor;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
        "DayOfWeek",
        "StartHour",
        "StartMinute",
        "EndHour",
        "EndMinute"
})

public class WorkingDay {

    @JsonProperty("DayOfWeek")
    private Integer dayOfWeek;
    @JsonProperty("StartHour")
    private Integer startHour;
    @JsonProperty("StartMinute")
    private Integer startMinute;
    @JsonProperty("EndHour")
    private Integer endHour;
    @JsonProperty("EndMinute")
    private Integer endMinute;

    /**
     * No args constructor for use in serialization
     *
     */
    public WorkingDay() {
    }

    /**
     *
     * @param endHour
     * @param dayOfWeek
     * @param startHour
     * @param startMinute
     * @param endMinute
     */
    public WorkingDay(Integer dayOfWeek, Integer startHour, Integer startMinute, Integer endHour, Integer endMinute) {
        super();
        this.dayOfWeek = dayOfWeek;
        this.startHour = startHour;
        this.startMinute = startMinute;
        this.endHour = endHour;
        this.endMinute = endMinute;
    }

    @JsonProperty("DayOfWeek")
    public Integer getDayOfWeek() {
        return dayOfWeek;
    }

    @JsonProperty("DayOfWeek")
    public void setDayOfWeek(Integer dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    @JsonProperty("StartHour")
    public Integer getStartHour() {
        return startHour;
    }

    @JsonProperty("StartHour")
    public void setStartHour(Integer startHour) {
        this.startHour = startHour;
    }

    @JsonProperty("StartMinute")
    public Integer getStartMinute() {
        return startMinute;
    }

    @JsonProperty("StartMinute")
    public void setStartMinute(Integer startMinute) {
        this.startMinute = startMinute;
    }

    @JsonProperty("EndHour")
    public Integer getEndHour() {
        return endHour;
    }

    @JsonProperty("EndHour")
    public void setEndHour(Integer endHour) {
        this.endHour = endHour;
    }

    @JsonProperty("EndMinute")
    public Integer getEndMinute() {
        return endMinute;
    }

    @JsonProperty("EndMinute")
    public void setEndMinute(Integer endMinute) {
        this.endMinute = endMinute;
    }

}

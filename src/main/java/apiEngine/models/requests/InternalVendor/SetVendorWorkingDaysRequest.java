package apiEngine.models.requests.InternalVendor;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "DeliveryInterval",
        "WorkingDays",
        "OperatingUserId"
})

public class SetVendorWorkingDaysRequest {

    @JsonProperty("DeliveryInterval")
    private Integer deliveryInterval;
    @JsonProperty("WorkingDays")
    private List<WorkingDay> workingDays = null;
    @JsonProperty("OperatingUserId")
    private String operatingUserId;

    /**
     * No args constructor for use in serialization
     *
     */
    public SetVendorWorkingDaysRequest() {
    }

    /**
     *
     * @param workingDays
     * @param deliveryInterval
     * @param operatingUserId
     */
    public SetVendorWorkingDaysRequest(Integer deliveryInterval, List<WorkingDay> workingDays, String operatingUserId) {
        super();
        this.deliveryInterval = deliveryInterval;
        this.workingDays = workingDays;
        this.operatingUserId = operatingUserId;
    }

    @JsonProperty("DeliveryInterval")
    public Integer getDeliveryInterval() {
        return deliveryInterval;
    }

    @JsonProperty("DeliveryInterval")
    public void setDeliveryInterval(Integer deliveryInterval) {
        this.deliveryInterval = deliveryInterval;
    }

    @JsonProperty("WorkingDays")
    public List<WorkingDay> getWorkingDays() {
        return workingDays;
    }

    @JsonProperty("WorkingDays")
    public void setWorkingDays(List<WorkingDay> workingDays) {
        this.workingDays = workingDays;
    }

    @JsonProperty("OperatingUserId")
    public String getOperatingUserId() {
        return operatingUserId;
    }

    @JsonProperty("OperatingUserId")
    public void setOperatingUserId(String operatingUserId) {
        this.operatingUserId = operatingUserId;
    }

}

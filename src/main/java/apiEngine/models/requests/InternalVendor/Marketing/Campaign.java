package apiEngine.models.requests.InternalVendor.Marketing;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Name",
        "UsageLimit",
        "IsOtpRequired",
        "IsOneTimePerUser",
        "IsCouponRequired",
        "IsShownOnCheckout",
        "StartDate",
        "EndDate"
})

public class Campaign {

    @JsonProperty("Name")
    private String name;
    @JsonProperty("UsageLimit")
    private Integer usageLimit;
    @JsonProperty("IsOtpRequired")
    private Boolean isOtpRequired;
    @JsonProperty("IsOneTimePerUser")
    private Boolean isOneTimePerUser;
    @JsonProperty("IsCouponRequired")
    private Boolean isCouponRequired;
    @JsonProperty("IsShownOnCheckout")
    private Boolean isShownOnCheckout;
    @JsonProperty("StartDate")
    private String startDate;
    @JsonProperty("EndDate")
    private String endDate;

    /**
     * No args constructor for use in serialization
     *
     */
    public Campaign() {
    }

    /**
     *
     * @param isOtpRequired
     * @param isShownOnCheckout
     * @param isCouponRequired
     * @param endDate
     * @param usageLimit
     * @param name
     * @param isOneTimePerUser
     * @param startDate
     */
    public Campaign(String name, Integer usageLimit, Boolean isOtpRequired, Boolean isOneTimePerUser, Boolean isCouponRequired, Boolean isShownOnCheckout, String startDate, String endDate) {
        super();
        this.name = name;
        this.usageLimit = usageLimit;
        this.isOtpRequired = isOtpRequired;
        this.isOneTimePerUser = isOneTimePerUser;
        this.isCouponRequired = isCouponRequired;
        this.isShownOnCheckout = isShownOnCheckout;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @JsonProperty("Name")
    public String getName() {
        return name;
    }

    @JsonProperty("Name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("UsageLimit")
    public Integer getUsageLimit() {
        return usageLimit;
    }

    @JsonProperty("UsageLimit")
    public void setUsageLimit(Integer usageLimit) {
        this.usageLimit = usageLimit;
    }

    @JsonProperty("IsOtpRequired")
    public Boolean getIsOtpRequired() {
        return isOtpRequired;
    }

    @JsonProperty("IsOtpRequired")
    public void setIsOtpRequired(Boolean isOtpRequired) {
        this.isOtpRequired = isOtpRequired;
    }

    @JsonProperty("IsOneTimePerUser")
    public Boolean getIsOneTimePerUser() {
        return isOneTimePerUser;
    }

    @JsonProperty("IsOneTimePerUser")
    public void setIsOneTimePerUser(Boolean isOneTimePerUser) {
        this.isOneTimePerUser = isOneTimePerUser;
    }

    @JsonProperty("IsCouponRequired")
    public Boolean getIsCouponRequired() {
        return isCouponRequired;
    }

    @JsonProperty("IsCouponRequired")
    public void setIsCouponRequired(Boolean isCouponRequired) {
        this.isCouponRequired = isCouponRequired;
    }

    @JsonProperty("IsShownOnCheckout")
    public Boolean getIsShownOnCheckout() {
        return isShownOnCheckout;
    }

    @JsonProperty("IsShownOnCheckout")
    public void setIsShownOnCheckout(Boolean isShownOnCheckout) {
        this.isShownOnCheckout = isShownOnCheckout;
    }

    @JsonProperty("StartDate")
    public String getStartDate() {
        return startDate;
    }

    @JsonProperty("StartDate")
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    @JsonProperty("EndDate")
    public String getEndDate() {
        return endDate;
    }

    @JsonProperty("EndDate")
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

}
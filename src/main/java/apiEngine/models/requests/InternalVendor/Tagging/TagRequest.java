package apiEngine.models.requests.InternalVendor.Tagging;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "description",
        "createdUserId",
        "createdUserName",
        "endDate",
        "details"
})

public class TagRequest {

    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;
    @JsonProperty("createdUserId")
    private String createdUserId;
    @JsonProperty("createdUserName")
    private String createdUserName;
    @JsonProperty("endDate")
    private String endDate;
    @JsonProperty("details")
    private List<String> details = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public TagRequest() {
    }

    /**
     *
     * @param createdUserId
     * @param createdUserName
     * @param endDate
     * @param name
     * @param description
     * @param details
     */
    public TagRequest(String name, String description, String createdUserId, String createdUserName, String endDate, List<String> details) {
        super();
        this.name = name;
        this.description = description;
        this.createdUserId = createdUserId;
        this.createdUserName = createdUserName;
        this.endDate = endDate;
        this.details = details;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("createdUserId")
    public String getCreatedUserId() {
        return createdUserId;
    }

    @JsonProperty("createdUserId")
    public void setCreatedUserId(String createdUserId) {
        this.createdUserId = createdUserId;
    }

    @JsonProperty("createdUserName")
    public String getCreatedUserName() {
        return createdUserName;
    }

    @JsonProperty("createdUserName")
    public void setCreatedUserName(String createdUserName) {
        this.createdUserName = createdUserName;
    }

    @JsonProperty("endDate")
    public String getEndDate() {
        return endDate;
    }

    @JsonProperty("endDate")
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @JsonProperty("details")
    public List<String> getDetails() {
        return details;
    }

    @JsonProperty("details")
    public void setDetails(List<String> details) {
        this.details = details;
    }

}
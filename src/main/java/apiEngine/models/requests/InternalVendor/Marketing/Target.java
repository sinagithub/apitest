package apiEngine.models.requests.InternalVendor.Marketing;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "TargetId",
        "TypeId"
})

public class Target {

    @JsonProperty("TargetId")
    private String targetId;
    @JsonProperty("TypeId")
    private Integer typeId;

    /**
     * No args constructor for use in serialization
     *
     */
    public Target() {
    }

    /**
     *
     * @param targetId
     * @param typeId
     */
    public Target(String targetId, Integer typeId) {
        super();
        this.targetId = targetId;
        this.typeId = typeId;
    }

    @JsonProperty("TargetId")
    public String getTargetId() {
        return targetId;
    }

    @JsonProperty("TargetId")
    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }

    @JsonProperty("TypeId")
    public Integer getTypeId() {
        return typeId;
    }

    @JsonProperty("TypeId")
    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

}
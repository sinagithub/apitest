package apiEngine.models.requests.InternalVendor.Marketing;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "TypeId",
        "OperatorTypeId",
        "Value"
})

public class Condition {

    @JsonProperty("TypeId")
    private Integer typeId;
    @JsonProperty("OperatorTypeId")
    private Integer operatorTypeId;
    @JsonProperty("Value")
    private String value;

    /**
     * No args constructor for use in serialization
     *
     */
    public Condition() {
    }

    /**
     *
     * @param operatorTypeId
     * @param typeId
     * @param value
     */
    public Condition(Integer typeId, Integer operatorTypeId, String value) {
        super();
        this.typeId = typeId;
        this.operatorTypeId = operatorTypeId;
        this.value = value;
    }

    @JsonProperty("TypeId")
    public Integer getTypeId() {
        return typeId;
    }

    @JsonProperty("TypeId")
    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    @JsonProperty("OperatorTypeId")
    public Integer getOperatorTypeId() {
        return operatorTypeId;
    }

    @JsonProperty("OperatorTypeId")
    public void setOperatorTypeId(Integer operatorTypeId) {
        this.operatorTypeId = operatorTypeId;
    }

    @JsonProperty("Value")
    public String getValue() {
        return value;
    }

    @JsonProperty("Value")
    public void setValue(String value) {
        this.value = value;
    }

}
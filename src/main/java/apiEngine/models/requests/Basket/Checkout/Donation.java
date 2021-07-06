package apiEngine.models.requests.Basket.Checkout;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "FoundationId",
        "TypeId",
        "Value"
})

public class Donation {

    @JsonProperty("FoundationId")
    private String foundationId;
    @JsonProperty("TypeId")
    private Integer typeId;
    @JsonProperty("Value")
    private Integer value;

    /**
     * No args constructor for use in serialization
     *
     */
    public Donation() {
    }

    /**
     *
     * @param foundationId
     * @param typeId
     * @param value
     */
    public Donation(String foundationId, Integer typeId, Integer value) {
        super();
        this.foundationId = foundationId;
        this.typeId = typeId;
        this.value = value;
    }

    @JsonProperty("FoundationId")
    public String getFoundationId() {
        return foundationId;
    }

    @JsonProperty("FoundationId")
    public void setFoundationId(String foundationId) {
        this.foundationId = foundationId;
    }

    @JsonProperty("TypeId")
    public Integer getTypeId() {
        return typeId;
    }

    @JsonProperty("TypeId")
    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    @JsonProperty("Value")
    public Integer getValue() {
        return value;
    }

    @JsonProperty("Value")
    public void setValue(Integer value) {
        this.value = value;
    }

}

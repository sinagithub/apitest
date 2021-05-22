package apiEngine.models.requests.Basket.Checkout;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
        "TypeId",
        "Value"
})

public class Tip {

    @JsonProperty("TypeId")
    private Integer typeId;
    @JsonProperty("Value")
    private Integer value;

    /**
     * No args constructor for use in serialization
     *
     */
    public Tip() {
    }

    /**
     *
     * @param typeId
     * @param value
     */
    public Tip(Integer typeId, Integer value) {
        super();
        this.typeId = typeId;
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

    @JsonProperty("Value")
    public Integer getValue() {
        return value;
    }

    @JsonProperty("Value")
    public void setValue(Integer value) {
        this.value = value;
    }

}

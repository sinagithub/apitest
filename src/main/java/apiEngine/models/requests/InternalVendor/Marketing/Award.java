package apiEngine.models.requests.InternalVendor.Marketing;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "TypeId",
        "DiscountTypeId",
        "DiscountValue",
        "MaxDiscountValue"
})
@Generated("jsonschema2pojo")
public class Award {

    @JsonProperty("TypeId")
    private Integer typeId;
    @JsonProperty("DiscountTypeId")
    private Integer discountTypeId;
    @JsonProperty("DiscountValue")
    private Integer discountValue;
    @JsonProperty("MaxDiscountValue")
    private Integer maxDiscountValue;

    /**
     * No args constructor for use in serialization
     *
     */
    public Award() {
    }

    /**
     *
     * @param discountTypeId
     * @param typeId
     * @param discountValue
     * @param maxDiscountValue
     */
    public Award(Integer typeId, Integer discountTypeId, Integer discountValue, Integer maxDiscountValue) {
        super();
        this.typeId = typeId;
        this.discountTypeId = discountTypeId;
        this.discountValue = discountValue;
        this.maxDiscountValue = maxDiscountValue;
    }

    @JsonProperty("TypeId")
    public Integer getTypeId() {
        return typeId;
    }

    @JsonProperty("TypeId")
    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    @JsonProperty("DiscountTypeId")
    public Integer getDiscountTypeId() {
        return discountTypeId;
    }

    @JsonProperty("DiscountTypeId")
    public void setDiscountTypeId(Integer discountTypeId) {
        this.discountTypeId = discountTypeId;
    }

    @JsonProperty("DiscountValue")
    public Integer getDiscountValue() {
        return discountValue;
    }

    @JsonProperty("DiscountValue")
    public void setDiscountValue(Integer discountValue) {
        this.discountValue = discountValue;
    }

    @JsonProperty("MaxDiscountValue")
    public Integer getMaxDiscountValue() {
        return maxDiscountValue;
    }

    @JsonProperty("MaxDiscountValue")
    public void setMaxDiscountValue(Integer maxDiscountValue) {
        this.maxDiscountValue = maxDiscountValue;
    }

}
package apiEngine.models.response.Basket.Checkout;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Id",
        "TypeId",
        "Value",
        "ValueText",
        "IsSelected"
})
@Generated("jsonschema2pojo")
public class Option {

    @JsonProperty("Id")
    private Integer id;
    @JsonProperty("TypeId")
    private Integer typeId;
    @JsonProperty("Value")
    private Integer value;
    @JsonProperty("ValueText")
    private String valueText;
    @JsonProperty("IsSelected")
    private Boolean isSelected;

    @JsonProperty("Id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("Id")
    public void setId(Integer id) {
        this.id = id;
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

    @JsonProperty("ValueText")
    public String getValueText() {
        return valueText;
    }

    @JsonProperty("ValueText")
    public void setValueText(String valueText) {
        this.valueText = valueText;
    }

    @JsonProperty("IsSelected")
    public Boolean getIsSelected() {
        return isSelected;
    }

    @JsonProperty("IsSelected")
    public void setIsSelected(Boolean isSelected) {
        this.isSelected = isSelected;
    }

}

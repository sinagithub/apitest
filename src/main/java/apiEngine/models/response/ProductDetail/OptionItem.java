package apiEngine.models.response.ProductDetail;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Id",
        "OptionId",
        "Value",
        "MaterialTypeId",
        "AdditionalPrice",
        "AdditionalPriceText",
        "IsAvailable",
        "IsSelected"
})

public class OptionItem {

    @JsonProperty("Id")
    private Integer id;
    @JsonProperty("OptionId")
    private Integer optionId;
    @JsonProperty("Value")
    private String value;
    @JsonProperty("MaterialTypeId")
    private Integer materialTypeId;
    @JsonProperty("AdditionalPrice")
    private Integer additionalPrice;
    @JsonProperty("AdditionalPriceText")
    private String additionalPriceText;
    @JsonProperty("IsAvailable")
    private Boolean isAvailable;
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

    @JsonProperty("OptionId")
    public Integer getOptionId() {
        return optionId;
    }

    @JsonProperty("OptionId")
    public void setOptionId(Integer optionId) {
        this.optionId = optionId;
    }

    @JsonProperty("Value")
    public String getValue() {
        return value;
    }

    @JsonProperty("Value")
    public void setValue(String value) {
        this.value = value;
    }

    @JsonProperty("MaterialTypeId")
    public Integer getMaterialTypeId() {
        return materialTypeId;
    }

    @JsonProperty("MaterialTypeId")
    public void setMaterialTypeId(Integer materialTypeId) {
        this.materialTypeId = materialTypeId;
    }

    @JsonProperty("AdditionalPrice")
    public Integer getAdditionalPrice() {
        return additionalPrice;
    }

    @JsonProperty("AdditionalPrice")
    public void setAdditionalPrice(Integer additionalPrice) {
        this.additionalPrice = additionalPrice;
    }

    @JsonProperty("AdditionalPriceText")
    public String getAdditionalPriceText() {
        return additionalPriceText;
    }

    @JsonProperty("AdditionalPriceText")
    public void setAdditionalPriceText(String additionalPriceText) {
        this.additionalPriceText = additionalPriceText;
    }

    @JsonProperty("IsAvailable")
    public Boolean getIsAvailable() {
        return isAvailable;
    }

    @JsonProperty("IsAvailable")
    public void setIsAvailable(Boolean isAvailable) {
        this.isAvailable = isAvailable;
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
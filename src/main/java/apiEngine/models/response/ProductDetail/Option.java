package apiEngine.models.response.ProductDetail;

import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Id",
        "Name",
        "DisplayName",
        "IsRequired",
        "DisplayType",
        "AffectsPrice",
        "Rank",
        "OptionItems"
})
@Generated("jsonschema2pojo")
public class Option {

    @JsonProperty("Id")
    private String id;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("DisplayName")
    private String displayName;
    @JsonProperty("IsRequired")
    private Boolean isRequired;
    @JsonProperty("DisplayType")
    private Integer displayType;
    @JsonProperty("AffectsPrice")
    private Boolean affectsPrice;
    @JsonProperty("Rank")
    private Integer rank;
    @JsonProperty("OptionItems")
    private List<OptionItem> optionItems = null;

    @JsonProperty("Id")
    public String getId() {
        return id;
    }

    @JsonProperty("Id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("Name")
    public String getName() {
        return name;
    }

    @JsonProperty("Name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("DisplayName")
    public String getDisplayName() {
        return displayName;
    }

    @JsonProperty("DisplayName")
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @JsonProperty("IsRequired")
    public Boolean getIsRequired() {
        return isRequired;
    }

    @JsonProperty("IsRequired")
    public void setIsRequired(Boolean isRequired) {
        this.isRequired = isRequired;
    }

    @JsonProperty("DisplayType")
    public Integer getDisplayType() {
        return displayType;
    }

    @JsonProperty("DisplayType")
    public void setDisplayType(Integer displayType) {
        this.displayType = displayType;
    }

    @JsonProperty("AffectsPrice")
    public Boolean getAffectsPrice() {
        return affectsPrice;
    }

    @JsonProperty("AffectsPrice")
    public void setAffectsPrice(Boolean affectsPrice) {
        this.affectsPrice = affectsPrice;
    }

    @JsonProperty("Rank")
    public Integer getRank() {
        return rank;
    }

    @JsonProperty("Rank")
    public void setRank(Integer rank) {
        this.rank = rank;
    }

    @JsonProperty("OptionItems")
    public List<OptionItem> getOptionItems() {
        return optionItems;
    }

    @JsonProperty("OptionItems")
    public void setOptionItems(List<OptionItem> optionItems) {
        this.optionItems = optionItems;
    }

}
package apiEngine.models.requests.Basket;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

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

public class OptionReq {

    @JsonProperty("Id")
    private Integer id;
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
    private List<OptionItemReq> optionItemReqs = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public OptionReq() {
    }

    /**
     *
     * @param isRequired
     * @param displayType
     * @param displayName
     * @param optionItemReqs
     * @param name
     * @param affectsPrice
     * @param rank
     * @param id
     */
    public OptionReq(Integer id, String name, String displayName, Boolean isRequired, Integer displayType, Boolean affectsPrice, Integer rank, List<OptionItemReq> optionItemReqs) {
        super();
        this.id = id;
        this.name = name;
        this.displayName = displayName;
        this.isRequired = isRequired;
        this.displayType = displayType;
        this.affectsPrice = affectsPrice;
        this.rank = rank;
        this.optionItemReqs = optionItemReqs;
    }

    @JsonProperty("Id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("Id")
    public void setId(Integer id) {
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
    public List<OptionItemReq> getOptionItems() {
        return optionItemReqs;
    }

    @JsonProperty("OptionItems")
    public void setOptionItems(List<OptionItemReq> optionItemReqs) {
        this.optionItemReqs = optionItemReqs;
    }

}
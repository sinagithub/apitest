package apiEngine.models.response.Basket.Campaign;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Id",
        "TypeId",
        "Title",
        "DiscountType",
        "DiscountTotal",
        "IsDefault",
        "IsOtpRequired",
        "ShortTitle"
})
@Generated("jsonschema2pojo")
public class CampaignItem {

    @JsonProperty("Id")
    private String id;
    @JsonProperty("TypeId")
    private Integer typeId;
    @JsonProperty("Title")
    private String title;
    @JsonProperty("DiscountType")
    private String discountType;
    @JsonProperty("DiscountTotal")
    private Double discountTotal;
    @JsonProperty("IsDefault")
    private Boolean isDefault;
    @JsonProperty("IsOtpRequired")
    private Boolean isOtpRequired;
    @JsonProperty("ShortTitle")
    private String shortTitle;

    /**
     * No args constructor for use in serialization
     *
     */
    public CampaignItem() {
    }

    /**
     *
     * @param isOtpRequired
     * @param isDefault
     * @param discountTotal
     * @param typeId
     * @param discountType
     * @param id
     * @param shortTitle
     * @param title
     */
    public CampaignItem(String id, Integer typeId, String title, String discountType, Double discountTotal, Boolean isDefault, Boolean isOtpRequired, String shortTitle) {
        super();
        this.id = id;
        this.typeId = typeId;
        this.title = title;
        this.discountType = discountType;
        this.discountTotal = discountTotal;
        this.isDefault = isDefault;
        this.isOtpRequired = isOtpRequired;
        this.shortTitle = shortTitle;
    }

    @JsonProperty("Id")
    public String getId() {
        return id;
    }

    @JsonProperty("Id")
    public void setId(String id) {
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

    @JsonProperty("Title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("Title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("DiscountType")
    public String getDiscountType() {
        return discountType;
    }

    @JsonProperty("DiscountType")
    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }

    @JsonProperty("DiscountTotal")
    public Double getDiscountTotal() {
        return discountTotal;
    }

    @JsonProperty("DiscountTotal")
    public void setDiscountTotal(Double discountTotal) {
        this.discountTotal = discountTotal;
    }

    @JsonProperty("IsDefault")
    public Boolean getIsDefault() {
        return isDefault;
    }

    @JsonProperty("IsDefault")
    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

    @JsonProperty("IsOtpRequired")
    public Boolean getIsOtpRequired() {
        return isOtpRequired;
    }

    @JsonProperty("IsOtpRequired")
    public void setIsOtpRequired(Boolean isOtpRequired) {
        this.isOtpRequired = isOtpRequired;
    }

    @JsonProperty("ShortTitle")
    public String getShortTitle() {
        return shortTitle;
    }

    @JsonProperty("ShortTitle")
    public void setShortTitle(String shortTitle) {
        this.shortTitle = shortTitle;
    }

}

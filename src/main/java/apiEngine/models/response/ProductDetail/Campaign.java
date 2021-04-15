package apiEngine.models.response.ProductDetail;

import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Id",
        "CampaignId",
        "CampaignTitle",
        "CampaignDescription",
        "ImageUrl",
        "TinyImageUrl",
        "Culture",
        "TargetDiscountType",
        "Products"
})
@Generated("jsonschema2pojo")
public class Campaign {

    @JsonProperty("Id")
    private String id;
    @JsonProperty("CampaignId")
    private String campaignId;
    @JsonProperty("CampaignTitle")
    private String campaignTitle;
    @JsonProperty("CampaignDescription")
    private String campaignDescription;
    @JsonProperty("ImageUrl")
    private String imageUrl;
    @JsonProperty("TinyImageUrl")
    private String tinyImageUrl;
    @JsonProperty("Culture")
    private String culture;
    @JsonProperty("TargetDiscountType")
    private Integer targetDiscountType;
    @JsonProperty("Products")
    private List<Product> products = null;

    @JsonProperty("Id")
    public String getId() {
        return id;
    }

    @JsonProperty("Id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("CampaignId")
    public String getCampaignId() {
        return campaignId;
    }

    @JsonProperty("CampaignId")
    public void setCampaignId(String campaignId) {
        this.campaignId = campaignId;
    }

    @JsonProperty("CampaignTitle")
    public String getCampaignTitle() {
        return campaignTitle;
    }

    @JsonProperty("CampaignTitle")
    public void setCampaignTitle(String campaignTitle) {
        this.campaignTitle = campaignTitle;
    }

    @JsonProperty("CampaignDescription")
    public String getCampaignDescription() {
        return campaignDescription;
    }

    @JsonProperty("CampaignDescription")
    public void setCampaignDescription(String campaignDescription) {
        this.campaignDescription = campaignDescription;
    }

    @JsonProperty("ImageUrl")
    public String getImageUrl() {
        return imageUrl;
    }

    @JsonProperty("ImageUrl")
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @JsonProperty("TinyImageUrl")
    public String getTinyImageUrl() {
        return tinyImageUrl;
    }

    @JsonProperty("TinyImageUrl")
    public void setTinyImageUrl(String tinyImageUrl) {
        this.tinyImageUrl = tinyImageUrl;
    }

    @JsonProperty("Culture")
    public String getCulture() {
        return culture;
    }

    @JsonProperty("Culture")
    public void setCulture(String culture) {
        this.culture = culture;
    }

    @JsonProperty("TargetDiscountType")
    public Integer getTargetDiscountType() {
        return targetDiscountType;
    }

    @JsonProperty("TargetDiscountType")
    public void setTargetDiscountType(Integer targetDiscountType) {
        this.targetDiscountType = targetDiscountType;
    }

    @JsonProperty("Products")
    public List<Product> getProducts() {
        return products;
    }

    @JsonProperty("Products")
    public void setProducts(List<Product> products) {
        this.products = products;
    }

}
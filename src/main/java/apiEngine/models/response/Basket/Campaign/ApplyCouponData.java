package apiEngine.models.response.Basket.Campaign;


import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "TotalCampaignCount",
        "BasketInfo",
        "Lines",
        "Campaigns",
        "ValidationInfo",
        "BasketVolume",
        "BagInfo",
        "Coupons"
})
@Generated("jsonschema2pojo")
public class Data {

    @JsonProperty("TotalCampaignCount")
    private Integer totalCampaignCount;
    @JsonProperty("BasketInfo")
    private BasketInfo basketInfo;
    @JsonProperty("Lines")
    private List<Line> lines = null;
    @JsonProperty("Campaigns")
    private List<Campaign> campaigns = null;
    @JsonProperty("ValidationInfo")
    private ValidationInfo validationInfo;
    @JsonProperty("BasketVolume")
    private Integer basketVolume;
    @JsonProperty("BagInfo")
    private BagInfo bagInfo;
    @JsonProperty("Coupons")
    private List<Coupon> coupons = null;

    @JsonProperty("TotalCampaignCount")
    public Integer getTotalCampaignCount() {
        return totalCampaignCount;
    }

    @JsonProperty("TotalCampaignCount")
    public void setTotalCampaignCount(Integer totalCampaignCount) {
        this.totalCampaignCount = totalCampaignCount;
    }

    @JsonProperty("BasketInfo")
    public BasketInfo getBasketInfo() {
        return basketInfo;
    }

    @JsonProperty("BasketInfo")
    public void setBasketInfo(BasketInfo basketInfo) {
        this.basketInfo = basketInfo;
    }

    @JsonProperty("Lines")
    public List<Line> getLines() {
        return lines;
    }

    @JsonProperty("Lines")
    public void setLines(List<Line> lines) {
        this.lines = lines;
    }

    @JsonProperty("Campaigns")
    public List<Campaign> getCampaigns() {
        return campaigns;
    }

    @JsonProperty("Campaigns")
    public void setCampaigns(List<Campaign> campaigns) {
        this.campaigns = campaigns;
    }

    @JsonProperty("ValidationInfo")
    public ValidationInfo getValidationInfo() {
        return validationInfo;
    }

    @JsonProperty("ValidationInfo")
    public void setValidationInfo(ValidationInfo validationInfo) {
        this.validationInfo = validationInfo;
    }

    @JsonProperty("BasketVolume")
    public Integer getBasketVolume() {
        return basketVolume;
    }

    @JsonProperty("BasketVolume")
    public void setBasketVolume(Integer basketVolume) {
        this.basketVolume = basketVolume;
    }

    @JsonProperty("BagInfo")
    public BagInfo getBagInfo() {
        return bagInfo;
    }

    @JsonProperty("BagInfo")
    public void setBagInfo(BagInfo bagInfo) {
        this.bagInfo = bagInfo;
    }

    @JsonProperty("Coupons")
    public List<Coupon> getCoupons() {
        return coupons;
    }

    @JsonProperty("Coupons")
    public void setCoupons(List<Coupon> coupons) {
        this.coupons = coupons;
    }

}
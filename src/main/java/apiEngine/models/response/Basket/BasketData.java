package apiEngine.models.response.Basket;
import java.util.List;
import javax.annotation.Generated;

import apiEngine.models.response.Basket.Campaign.Campaign;
import apiEngine.models.response.Basket.Campaign.Coupon;
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
        "Coupons"
})
@Generated("jsonschema2pojo")
public class BasketData {

    @JsonProperty("TotalCampaignCount")
    private Integer totalCampaignCount;
    @JsonProperty("BasketInfo")
    private BasketInfo basketInfo;
    @JsonProperty("Lines")
    private List<BasketLine> basketLines = null;
    @JsonProperty("Campaigns")
    private List<Campaign> campaigns = null;
    @JsonProperty("ValidationInfo")
    private ValidationInfo validationInfo;
    @JsonProperty("BasketVolume")
    private Integer basketVolume;
    @JsonProperty("Coupons")
    private List<Coupon> coupons = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public BasketData() {
    }

    /**
     *
     * @param totalCampaignCount
     * @param campaigns
     * @param coupons
     * @param basketInfo
     * @param validationInfo
     * @param basketVolume
     * @param basketLines
     */
    public BasketData(Integer totalCampaignCount, BasketInfo basketInfo, List<BasketLine> basketLines, List<Campaign> campaigns, ValidationInfo validationInfo, Integer basketVolume, List<Coupon> coupons) {
        super();
        this.totalCampaignCount = totalCampaignCount;
        this.basketInfo = basketInfo;
        this.basketLines = basketLines;
        this.campaigns = campaigns;
        this.validationInfo = validationInfo;
        this.basketVolume = basketVolume;
        this.coupons = coupons;
    }

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
    public List<BasketLine> getLines() {
        return basketLines;
    }

    @JsonProperty("Lines")
    public void setLines(List<BasketLine> basketLines) {
        this.basketLines = basketLines;
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

    @JsonProperty("Coupons")
    public List<Coupon> getCoupons() {
        return coupons;
    }

    @JsonProperty("Coupons")
    public void setCoupons(List<Coupon> coupons) {
        this.coupons = coupons;
    }

}
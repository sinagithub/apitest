package apiEngine.models.response.Basket;

import java.util.List;


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
        "BagInfo",
        "Coupons"
})

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
    @JsonProperty("BagInfo")
    private BagInfo bagInfo;
    @JsonProperty("Coupons")
    private List<Coupon> coupons = null;

    /**
     * No args constructor for use in serialization
     */
    public BasketData() {
    }

    /**
     * @param totalCampaignCount
     * @param campaigns
     * @param coupons
     * @param basketInfo
     * @param validationInfo
     * @param bagInfo
     * @param basketLines
     */
    public BasketData(Integer totalCampaignCount, BasketInfo basketInfo, List<BasketLine> basketLines,
                      List<Campaign> campaigns, ValidationInfo validationInfo, List<Coupon> coupons,
                      BagInfo bagInfo) {
        super();
        this.totalCampaignCount = totalCampaignCount;
        this.basketInfo = basketInfo;
        this.basketLines = basketLines;
        this.campaigns = campaigns;
        this.validationInfo = validationInfo;
        this.coupons = coupons;
        this.bagInfo = bagInfo;
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

    @JsonProperty("Coupons")
    public List<Coupon> getCoupons() {
        return coupons;
    }

    @JsonProperty("Coupons")
    public void setCoupons(List<Coupon> coupons) {
        this.coupons = coupons;
    }

    @JsonProperty("BagInfo")
    public BagInfo getBagInfo() {
        return bagInfo;
    }

    @JsonProperty("BagInfo")
    public void setBagInfo(BagInfo bagInfo) {
        this.bagInfo = bagInfo;
    }

}
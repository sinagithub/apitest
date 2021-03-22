package apiEngine.models.response.Basket;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "VendorId",
        "TotalCampaignCount",
        "BasketInfo",
        "Lines",
        "Campaigns",
        "Coupons"
})
public class BasketData {

    @JsonProperty("VendorId")
    private String vendorId;
    @JsonProperty("TotalCampaignCount")
    private Integer totalCampaignCount;
    @JsonProperty("BasketInfo")
    private BasketInfo basketInfo;
    @JsonProperty("Lines")
    private List<Line> lines = null;
    @JsonProperty("Campaigns")
    private List<BasketCampaign> basketCampaigns = null;
    @JsonProperty("Coupons")
    private List<Coupon> coupons = null;

    @JsonProperty("VendorId")
    public String getVendorId() {
        return vendorId;
    }

    @JsonProperty("VendorId")
    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
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
    public List<Line> getLines() {
        return lines;
    }

    @JsonProperty("Lines")
    public void setLines(List<Line> lines) {
        this.lines = lines;
    }

    @JsonProperty("Campaigns")
    public List<BasketCampaign> getCampaigns() {
        return basketCampaigns;
    }

    @JsonProperty("Campaigns")
    public void setCampaigns(List<BasketCampaign> basketCampaigns) {
        this.basketCampaigns = basketCampaigns;
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

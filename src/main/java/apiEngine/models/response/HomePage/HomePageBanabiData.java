package apiEngine.models.response.HomePage;

import java.util.List;

import apiEngine.models.response.BanabiCategoryModel;
import apiEngine.models.response.MahalleVendor;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonPropertyOrder({
        "VendorInfo",
        "BanabiCategoryModel",
        "HasBanabiFavorites"
})
public class HomePageBanabiData {

    @JsonProperty("VendorInfo")
    private MahalleVendor vendorInfo;
    @JsonProperty("BanabiCategoryModel")
    private List<BanabiCategoryModel> banabiCategoryModel = null;
    @JsonProperty("HasBanabiFavorites")
    private Boolean hasBanabiFavorites;

    @JsonProperty("VendorInfo")
    public MahalleVendor getVendorInfo() {
        return vendorInfo;
    }

    @JsonProperty("VendorInfo")
    public void setVendorInfo(MahalleVendor vendorInfo) {
        this.vendorInfo = vendorInfo;
    }

    @JsonProperty("BanabiCategoryModel")
    public List<BanabiCategoryModel> getBanabiCategoryModel() {
        return banabiCategoryModel;
    }

    @JsonProperty("BanabiCategoryModel")
    public void setBanabiCategoryModel(List<BanabiCategoryModel> banabiCategoryModel) {
        this.banabiCategoryModel = banabiCategoryModel;
    }

    @JsonProperty("HasBanabiFavorites")
    public Boolean getHasBanabiFavorites() {
        return hasBanabiFavorites;
    }

    @JsonProperty("HasBanabiFavorites")
    public void setHasBanabiFavorites(Boolean hasBanabiFavorites) {
        this.hasBanabiFavorites = hasBanabiFavorites;
    }

}
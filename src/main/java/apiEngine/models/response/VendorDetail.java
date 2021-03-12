package apiEngine.models.response;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Name",
        "AreaName",
        "Identifier",
        "ThumbImageUrl",
        "DeliveryTimeInfo",
        "MinBasketPriceInfo",
        "DeliveryFeeInfo",
        "Banners",
        "Categories"
})
public class VendorDetail {

    @JsonProperty("Name")
    private String name;
    @JsonProperty("AreaName")
    private String areaName;
    @JsonProperty("Identifier")
    private String identifier;
    @JsonProperty("ThumbImageUrl")
    private String thumbImageUrl;
    @JsonProperty("DeliveryTimeInfo")
    private String deliveryTimeInfo;
    @JsonProperty("MinBasketPriceInfo")
    private String minBasketPriceInfo;
    @JsonProperty("DeliveryFeeInfo")
    private String deliveryFeeInfo;
    @JsonProperty("Banners")
    private List<Banner> banners = null;
    @JsonProperty("Categories")
    private List<VendorCategories> categories = null;

    @JsonProperty("Name")
    public String getName() {
        return name;
    }

    @JsonProperty("Name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("AreaName")
    public String getAreaName() {
        return areaName;
    }

    @JsonProperty("AreaName")
    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    @JsonProperty("Identifier")
    public String getIdentifier() {
        return identifier;
    }

    @JsonProperty("Identifier")
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    @JsonProperty("ThumbImageUrl")
    public String getThumbImageUrl() {
        return thumbImageUrl;
    }

    @JsonProperty("ThumbImageUrl")
    public void setThumbImageUrl(String thumbImageUrl) {
        this.thumbImageUrl = thumbImageUrl;
    }

    @JsonProperty("DeliveryTimeInfo")
    public String getDeliveryTimeInfo() {
        return deliveryTimeInfo;
    }

    @JsonProperty("DeliveryTimeInfo")
    public void setDeliveryTimeInfo(String deliveryTimeInfo) {
        this.deliveryTimeInfo = deliveryTimeInfo;
    }

    @JsonProperty("MinBasketPriceInfo")
    public String getMinBasketPriceInfo() {
        return minBasketPriceInfo;
    }

    @JsonProperty("MinBasketPriceInfo")
    public void setMinBasketPriceInfo(String minBasketPriceInfo) {
        this.minBasketPriceInfo = minBasketPriceInfo;
    }

    @JsonProperty("DeliveryFeeInfo")
    public String getDeliveryFeeInfo() {
        return deliveryFeeInfo;
    }

    @JsonProperty("DeliveryFeeInfo")
    public void setDeliveryFeeInfo(String deliveryFeeInfo) {
        this.deliveryFeeInfo = deliveryFeeInfo;
    }

    @JsonProperty("Banners")
    public List<Banner> getBanners() {
        return banners;
    }

    @JsonProperty("Banners")
    public void setBanners(List<Banner> banners) {
        this.banners = banners;
    }

    @JsonProperty("Categories")
    public List<VendorCategories> getCategories() {
        return categories;
    }

    @JsonProperty("Categories")
    public void setCategories(List<VendorCategories> categories) {
        this.categories = categories;
    }

}

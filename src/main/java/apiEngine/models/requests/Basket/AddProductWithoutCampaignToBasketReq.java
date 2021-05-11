package apiEngine.models.requests.Basket;

import java.util.List;

import apiEngine.models.response.ProductDetail.Option;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "ProductId",
        "LineItemId",
        "Quantity",
        "CampaignProductId",
        "CampaignProductQuantity",
        "CampaignId",
        "VendorId",
        "Options"
})
public class AddProductWithoutCampaignToBasketReq {

    @JsonProperty("ProductId")
    private String productId;
    @JsonProperty("LineItemId")
    private String lineItemId;
    @JsonProperty("Quantity")
    private Integer quantity;
    @JsonProperty("CampaignProductId")
    private String campaignProductId;
    @JsonProperty("CampaignProductQuantity")
    private Integer campaignProductQuantity;
    @JsonProperty("CampaignId")
    private Integer campaignId;
    @JsonProperty("VendorId")
    private String vendorId;
    @JsonProperty("Options")
    private List<Option> options = null;

    public AddProductWithoutCampaignToBasketReq() {
    }

    /**
     *
     * @param quantity
     * @param productId
     * @param lineItemId
     * @param campaignProductId
     * @param campaignId
     * @param campaignProductQuantity
     * @param options
     * @param vendorId
     */
    public AddProductWithoutCampaignToBasketReq(String productId, String lineItemId, Integer quantity, String campaignProductId, Integer campaignProductQuantity, Integer campaignId, String vendorId, List<Option> options) {
        super();
        this.productId = productId;
        this.lineItemId = lineItemId;
        this.quantity = quantity;
        this.campaignProductId = campaignProductId;
        this.campaignProductQuantity = campaignProductQuantity;
        this.campaignId = campaignId;
        this.vendorId = vendorId;
        this.options = options;
    }

    @JsonProperty("ProductId")
    public String getProductId() {
        return productId;
    }

    @JsonProperty("ProductId")
    public void setProductId(String productId) {
        this.productId = productId;
    }

    @JsonProperty("LineItemId")
    public String getLineItemId() {
        return lineItemId;
    }

    @JsonProperty("LineItemId")
    public void setLineItemId(String lineItemId) {
        this.lineItemId = lineItemId;
    }

    @JsonProperty("Quantity")
    public Integer getQuantity() {
        return quantity;
    }

    @JsonProperty("Quantity")
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @JsonProperty("CampaignProductId")
    public String getCampaignProductId() {
        return campaignProductId;
    }

    @JsonProperty("CampaignProductId")
    public void setCampaignProductId(String campaignProductId) {
        this.campaignProductId = campaignProductId;
    }

    @JsonProperty("CampaignProductQuantity")
    public Integer getCampaignProductQuantity() {
        return campaignProductQuantity;
    }

    @JsonProperty("CampaignProductQuantity")
    public void setCampaignProductQuantity(Integer campaignProductQuantity) {
        this.campaignProductQuantity = campaignProductQuantity;
    }

    @JsonProperty("CampaignId")
    public Integer getCampaignId() {
        return campaignId;
    }

    @JsonProperty("CampaignId")
    public void setCampaignId(Integer campaignId) {
        this.campaignId = campaignId;
    }

    @JsonProperty("VendorId")
    public String getVendorId() {
        return vendorId;
    }

    @JsonProperty("VendorId")
    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    @JsonProperty("Options")
    public List<Option> getOptions() {
        return options;
    }

    @JsonProperty("Options")
    public void setOptions(List<Option> options) {
        this.options = options;
    }

}

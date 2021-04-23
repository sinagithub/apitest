package apiEngine.models.requests.Basket;

import java.util.List;
import javax.annotation.Generated;

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
        "CampaingId",
        "Options"
})
@Generated("jsonschema2pojo")
public class AddProductReq {

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
    @JsonProperty("CampaingId")
    private Integer campaingId;
    @JsonProperty("Options")
    private List<OptionReq> optionReqs = null;

    public AddProductReq() {
    }

    /**
     * @param quantity
     * @param productId
     * @param lineItemId
     * @param campaignProductId
     * @param campaignProductQuantity
     * @param optionReqs
     * @param campaingId
     */
    public AddProductReq(String productId, String lineItemId, Integer quantity, String campaignProductId,
                         Integer campaignProductQuantity, Integer campaingId, List<OptionReq> optionReqs) {
        super();
        this.productId = productId;
        this.lineItemId = lineItemId;
        this.quantity = quantity;
        this.campaignProductId = campaignProductId;
        this.campaignProductQuantity = campaignProductQuantity;
        this.campaingId = campaingId;
        this.optionReqs = optionReqs;
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

    @JsonProperty("CampaingId")
    public Integer getCampaingId() {
        return campaingId;
    }

    @JsonProperty("CampaingId")
    public void setCampaingId(Integer campaingId) {
        this.campaingId = campaingId;
    }

    @JsonProperty("Options")
    public List<OptionReq> getOptions() {
        return optionReqs;
    }

    @JsonProperty("Options")
    public void setOptions(List<OptionReq> optionReqs) {
        this.optionReqs = optionReqs;
    }

}
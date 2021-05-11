package apiEngine.models.response.Basket;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "LightBasket",
        "CampaignErrors",
        "ProductErrors"
})
@Generated("jsonschema2pojo")
public class AddBasketData {

    @JsonProperty("LightBasket")
    private LightBasket lightBasket;
    @JsonProperty("CampaignErrors")
    private CampaignErrors campaignErrors;
    @JsonProperty("ProductErrors")
    private ProductErrors productErrors;

    @JsonProperty("LightBasket")
    public LightBasket getLightBasket() {
        return lightBasket;
    }

    @JsonProperty("LightBasket")
    public void setLightBasket(LightBasket lightBasket) {
        this.lightBasket = lightBasket;
    }

    @JsonProperty("CampaignErrors")
    public CampaignErrors getCampaignErrors() {
        return campaignErrors;
    }

    @JsonProperty("CampaignErrors")
    public void setCampaignErrors(CampaignErrors campaignErrors) {
        this.campaignErrors = campaignErrors;
    }

    @JsonProperty("ProductErrors")
    public ProductErrors getProductErrors() {
        return productErrors;
    }

    @JsonProperty("ProductErrors")
    public void setProductErrors(ProductErrors productErrors) {
        this.productErrors = productErrors;
    }

}
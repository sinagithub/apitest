package apiEngine.models.response.Basket;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "LightBasket",
        "CampaignErrors",
        "ProductErrors"
})

public class AddBasketData {

    @JsonProperty("LightBasket")
    private LiteBasketData lightBasket;
    @JsonProperty("CampaignErrors")
    private CampaignErrors campaignErrors;
    @JsonProperty("ProductErrors")
    private ProductErrors productErrors;

    @JsonProperty("LightBasket")
    public LiteBasketData getLightBasket() {
        return lightBasket;
    }

    @JsonProperty("LightBasket")
    public void setLightBasket(LiteBasketData lightBasket) {
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
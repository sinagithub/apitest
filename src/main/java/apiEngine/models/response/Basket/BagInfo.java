package apiEngine.models.response.Basket;



import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "BagPrice",
        "BagCount",
        "BagTitle"
})

public class BagInfo {

    @JsonProperty("BagPrice")
    private Double bagPrice;
    @JsonProperty("BagCount")
    private Integer bagCount;
    @JsonProperty("BagTitle")
    private String bagTitle;

    @JsonProperty("BagPrice")
    public Double getBagPrice() {
        return bagPrice;
    }

    @JsonProperty("BagPrice")
    public void setBagPrice(Double bagPrice) {
        this.bagPrice = bagPrice;
    }

    @JsonProperty("BagCount")
    public Integer getBagCount() {
        return bagCount;
    }

    @JsonProperty("BagCount")
    public void setBagCount(Integer bagCount) {
        this.bagCount = bagCount;
    }

    @JsonProperty("BagTitle")
    public String getBagTitle() {
        return bagTitle;
    }

    @JsonProperty("BagTitle")
    public void setBagTitle(String bagTitle) {
        this.bagTitle = bagTitle;
    }

}
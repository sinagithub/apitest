package apiEngine.models.response.Basket;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Lines",
        "TotalLinesItemCount",
        "VendorId"
})

public class LightBasket {

    @JsonProperty("Lines")
    private List<BasketLine> basketLines = null;
    @JsonProperty("TotalLinesItemCount")
    private Integer totalLinesItemCount;
    @JsonProperty("VendorId")
    private String vendorId;

    @JsonProperty("Lines")
    public List<BasketLine> getLines() {
        return basketLines;
    }

    @JsonProperty("Lines")
    public void setLines(List<BasketLine> basketLines) {
        this.basketLines = basketLines;
    }

    @JsonProperty("TotalLinesItemCount")
    public Integer getTotalLinesItemCount() {
        return totalLinesItemCount;
    }

    @JsonProperty("TotalLinesItemCount")
    public void setTotalLinesItemCount(Integer totalLinesItemCount) {
        this.totalLinesItemCount = totalLinesItemCount;
    }

    @JsonProperty("VendorId")
    public String getVendorId() {
        return vendorId;
    }

    @JsonProperty("VendorId")
    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

}
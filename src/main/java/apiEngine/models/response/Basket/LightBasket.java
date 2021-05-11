package apiEngine.models.response.Basket;

import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Lines",
        "TotalLinesItemCount",
        "VendorId"
})
@Generated("jsonschema2pojo")
public class LightBasket {

    @JsonProperty("Lines")
    private List<Line> lines = null;
    @JsonProperty("TotalLinesItemCount")
    private Integer totalLinesItemCount;
    @JsonProperty("VendorId")
    private String vendorId;

    @JsonProperty("Lines")
    public List<Line> getLines() {
        return lines;
    }

    @JsonProperty("Lines")
    public void setLines(List<Line> lines) {
        this.lines = lines;
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
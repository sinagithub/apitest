package apiEngine.models.response.Basket;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "VendorId",
        "Total",
        "SubTotal",
        "Lines"
})
public class LiteData {

    @JsonProperty("VendorId")
    private String vendorId;
    @JsonProperty("Total")
    private Integer total;
    @JsonProperty("SubTotal")
    private Integer subTotal;
    @JsonProperty("Lines")
    private List<Line> lines = null;

    @JsonProperty("VendorId")
    public String getVendorId() {
        return vendorId;
    }

    @JsonProperty("VendorId")
    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    @JsonProperty("Total")
    public Integer getTotal() {
        return total;
    }

    @JsonProperty("Total")
    public void setTotal(Integer total) {
        this.total = total;
    }

    @JsonProperty("SubTotal")
    public Integer getSubTotal() {
        return subTotal;
    }

    @JsonProperty("SubTotal")
    public void setSubTotal(Integer subTotal) {
        this.subTotal = subTotal;
    }

    @JsonProperty("Lines")
    public List<Line> getLines() {
        return lines;
    }

    @JsonProperty("Lines")
    public void setLines(List<Line> lines) {
        this.lines = lines;
    }
}

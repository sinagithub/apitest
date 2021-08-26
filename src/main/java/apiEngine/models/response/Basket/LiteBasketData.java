package apiEngine.models.response.Basket;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Lines",
        "TotalLinesItemCount",
        "VendorId",
        "PlatformType"
})

public class LiteBasketData {

    @JsonProperty("Lines")
    private List<LiteBasketLine> lines = null;
    @JsonProperty("TotalLinesItemCount")
    private Integer totalLinesItemCount;
    @JsonProperty("VendorId")
    private String vendorId;
    @JsonProperty("PlatformType")
    private String platformType;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Lines")
    public List<LiteBasketLine> getLines() {
        return lines;
    }

    @JsonProperty("Lines")
    public void setLines(List<LiteBasketLine> lines) {
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

    @JsonProperty("PlatformType")
    public String getPlatformType() {
        return platformType;
    }

    @JsonProperty("PlatformType")
    public void setPlatformType(String platformType) {
        this.platformType = platformType;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
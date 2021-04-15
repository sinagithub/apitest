package apiEngine.models.response.Vendor;

import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Products",
        "PrevOffset",
        "NextOffset",
        "HasNextPage",
        "HasPrevPage"
})
@Generated("jsonschema2pojo")
public class ProductsData {

    @JsonProperty("Products")
    private List<Product> products = null;
    @JsonProperty("PrevOffset")
    private Integer prevOffset;
    @JsonProperty("NextOffset")
    private Integer nextOffset;
    @JsonProperty("HasNextPage")
    private Boolean hasNextPage;
    @JsonProperty("HasPrevPage")
    private Boolean hasPrevPage;

    @JsonProperty("Products")
    public List<Product> getProducts() {
        return products;
    }

    @JsonProperty("Products")
    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @JsonProperty("PrevOffset")
    public Integer getPrevOffset() {
        return prevOffset;
    }

    @JsonProperty("PrevOffset")
    public void setPrevOffset(Integer prevOffset) {
        this.prevOffset = prevOffset;
    }

    @JsonProperty("NextOffset")
    public Integer getNextOffset() {
        return nextOffset;
    }

    @JsonProperty("NextOffset")
    public void setNextOffset(Integer nextOffset) {
        this.nextOffset = nextOffset;
    }

    @JsonProperty("HasNextPage")
    public Boolean getHasNextPage() {
        return hasNextPage;
    }

    @JsonProperty("HasNextPage")
    public void setHasNextPage(Boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }

    @JsonProperty("HasPrevPage")
    public Boolean getHasPrevPage() {
        return hasPrevPage;
    }

    @JsonProperty("HasPrevPage")
    public void setHasPrevPage(Boolean hasPrevPage) {
        this.hasPrevPage = hasPrevPage;
    }

}

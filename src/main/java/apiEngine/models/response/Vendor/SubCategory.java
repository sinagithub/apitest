package apiEngine.models.response.Vendor;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Id",
        "Name",
        "Order",
        "Offset"
})
@Generated("jsonschema2pojo")
public class SubCategory {

    @JsonProperty("Id")
    private String id;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("Order")
    private Integer order;
    @JsonProperty("Offset")
    private Integer offset;
    @JsonProperty("ProductCount")
    private Integer productCount;

    @JsonProperty("Id")
    public String getId() {
        return id;
    }

    @JsonProperty("Id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("Name")
    public String getName() {
        return name;
    }

    @JsonProperty("Name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("Order")
    public Integer getOrder() {
        return order;
    }

    @JsonProperty("Order")
    public void setOrder(Integer order) {
        this.order = order;
    }

    @JsonProperty("Offset")
    public Integer getOffset() {
        return offset;
    }

    @JsonProperty("Offset")
    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getProductCount() {
        return productCount;
    }

    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }
}

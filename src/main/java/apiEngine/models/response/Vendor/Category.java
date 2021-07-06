package apiEngine.models.response.Vendor;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Id",
        "Name",
        "ThumbImageUrl",
        "Order",
        "ProductCount",
        "SubCategories"
})

public class Category {

    @JsonProperty("Id")
    private String id;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("ThumbImageUrl")
    private String thumbImageUrl;
    @JsonProperty("Order")
    private Integer order;
    @JsonProperty("ProductCount")
    private Integer productCount;
    @JsonProperty("SubCategories")
    private List<SubCategory> subCategories = null;

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

    @JsonProperty("ThumbImageUrl")
    public String getThumbImageUrl() {
        return thumbImageUrl;
    }

    @JsonProperty("ThumbImageUrl")
    public void setThumbImageUrl(String thumbImageUrl) {
        this.thumbImageUrl = thumbImageUrl;
    }

    @JsonProperty("Order")
    public Integer getOrder() {
        return order;
    }

    @JsonProperty("Order")
    public void setOrder(Integer order) {
        this.order = order;
    }

    @JsonProperty("ProductCount")
    public Integer getProductCount() {
        return productCount;
    }

    @JsonProperty("ProductCount")
    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }

    @JsonProperty("SubCategories")
    public List<SubCategory> getSubCategories() {
        return subCategories;
    }

    @JsonProperty("SubCategories")
    public void setSubCategories(List<SubCategory> subCategories) {
        this.subCategories = subCategories;
    }

}
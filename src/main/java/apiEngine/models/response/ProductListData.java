package apiEngine.models.response;


import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Categories"
})
public class ProductListData {

    @JsonProperty("Categories")
    private List<ProductCategory> categories = null;

    @JsonProperty("Categories")
    public List<ProductCategory> getCategories() {
        return categories;
    }

    @JsonProperty("Categories")
    public void setCategories(List<ProductCategory> categories) {
        this.categories = categories;
    }

}

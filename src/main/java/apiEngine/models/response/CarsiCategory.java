package apiEngine.models.response;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "CategoryId",
        "CategoryName"
})
@Generated("jsonschema2pojo")
public class CarsiCategory {

    @JsonProperty("CategoryId")
    private String categoryId;
    @JsonProperty("CategoryName")
    private String categoryName;

    @JsonProperty("CategoryId")
    public String getCategoryId() {
        return categoryId;
    }

    @JsonProperty("CategoryId")
    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    @JsonProperty("CategoryName")
    public String getCategoryName() {
        return categoryName;
    }

    @JsonProperty("CategoryName")
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

}
package apiEngine.models.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "CategoryId",
        "CategoryName",
        "IsAllCategory"
})

public class MahalleCategory {

    @JsonProperty("CategoryId")
    private String categoryId;
    @JsonProperty("CategoryName")
    private String categoryName;
    @JsonProperty("IsAllCategory")
    private Boolean isAllCategory;

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

    @JsonProperty("IsAllCategory")
    public Boolean getIsAllCategory() {
        return isAllCategory;
    }

    @JsonProperty("IsAllCategory")
    public void setIsAllCategory(Boolean isAllCategory) {
        this.isAllCategory = isAllCategory;
    }
}

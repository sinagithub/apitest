package apiEngine.models.response;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonPropertyOrder({
        "ThumbImageUrl",
        "SeoUrl",
        "CategoryId",
        "DisplayName"
})

public class BanabiCategoryModel {

    @JsonProperty("ThumbImageUrl")
    private String thumbImageUrl;
    @JsonProperty("SeoUrl")
    private String seoUrl;
    @JsonProperty("CategoryId")
    private Integer categoryId;
    @JsonProperty("DisplayName")
    private String displayName;

    @JsonProperty("ThumbImageUrl")
    public String getThumbImageUrl() {
        return thumbImageUrl;
    }

    @JsonProperty("ThumbImageUrl")
    public void setThumbImageUrl(String thumbImageUrl) {
        this.thumbImageUrl = thumbImageUrl;
    }

    @JsonProperty("SeoUrl")
    public String getSeoUrl() {
        return seoUrl;
    }

    @JsonProperty("SeoUrl")
    public void setSeoUrl(String seoUrl) {
        this.seoUrl = seoUrl;
    }

    @JsonProperty("CategoryId")
    public Integer getCategoryId() {
        return categoryId;
    }

    @JsonProperty("CategoryId")
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    @JsonProperty("DisplayName")
    public String getDisplayName() {
        return displayName;
    }

    @JsonProperty("DisplayName")
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

}
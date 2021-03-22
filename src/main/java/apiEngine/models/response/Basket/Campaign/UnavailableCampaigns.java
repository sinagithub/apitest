package apiEngine.models.response.Basket.Campaign;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Id",
        "Title",
        "Description",
        "ImageUrl",
        "IsMultiProduct",
        "IsProductRelated",
        "Selected"
})
public class UnavailableCampaigns {

    @JsonProperty("Id")
    private Integer id;
    @JsonProperty("Title")
    private String title;
    @JsonProperty("Description")
    private String description;
    @JsonProperty("ImageUrl")
    private String imageUrl;
    @JsonProperty("IsMultiProduct")
    private Boolean isMultiProduct;
    @JsonProperty("IsProductRelated")
    private Boolean isProductRelated;
    @JsonProperty("Selected")
    private Boolean selected;

    @JsonProperty("Id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("Id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("Title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("Title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("Description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("Description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("ImageUrl")
    public String getImageUrl() {
        return imageUrl;
    }

    @JsonProperty("ImageUrl")
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @JsonProperty("IsMultiProduct")
    public Boolean getIsMultiProduct() {
        return isMultiProduct;
    }

    @JsonProperty("IsMultiProduct")
    public void setIsMultiProduct(Boolean isMultiProduct) {
        this.isMultiProduct = isMultiProduct;
    }

    @JsonProperty("IsProductRelated")
    public Boolean getIsProductRelated() {
        return isProductRelated;
    }

    @JsonProperty("IsProductRelated")
    public void setIsProductRelated(Boolean isProductRelated) {
        this.isProductRelated = isProductRelated;
    }

    @JsonProperty("Selected")
    public Boolean getSelected() {
        return selected;
    }

    @JsonProperty("Selected")
    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

}
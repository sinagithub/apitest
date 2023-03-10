package apiEngine.models.requests.InternalVendor.Marketing;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Title",
        "Description",
        "ImageUrl"
})

public class DescriptionTr {

    @JsonProperty("Title")
    private String title;
    @JsonProperty("Description")
    private String description;
    @JsonProperty("ImageUrl")
    private String imageUrl;

    /**
     * No args constructor for use in serialization
     *
     */
    public DescriptionTr() {
    }

    /**
     *
     * @param imageUrl
     * @param description
     * @param title
     */
    public DescriptionTr(String title, String description, String imageUrl) {
        super();
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
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

}
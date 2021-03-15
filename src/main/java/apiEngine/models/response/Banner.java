package apiEngine.models.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonPropertyOrder({
        "ImageUrl",
        "SeoUrl"
})
public class Banner {

    @JsonProperty("ImageUrl")
    private String imageUrl;
    @JsonProperty("SeoUrl")
    private String seoUrl;

    @JsonProperty("ImageUrl")
    public String getImageUrl() {
        return imageUrl;
    }

    @JsonProperty("ImageUrl")
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @JsonProperty("SeoUrl")
    public String getSeoUrl() {
        return seoUrl;
    }

    @JsonProperty("SeoUrl")
    public void setSeoUrl(String seoUrl) {
        this.seoUrl = seoUrl;
    }

}
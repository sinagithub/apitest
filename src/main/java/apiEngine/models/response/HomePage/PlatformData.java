package apiEngine.models.response.HomePage;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Platform",
        "ImageUrl"
})
public class PlatformData {

    @JsonProperty("Platform")
    private String platform;
    @JsonProperty("ImageUrl")
    private String imageUrl;

    @JsonProperty("Platform")
    public String getPlatform() {
        return platform;
    }

    @JsonProperty("Platform")
    public void setPlatform(String platform) {
        this.platform = platform;
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
package apiEngine.models.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Id",
        "ImageUrl",
        "DeeplinkUrl",
        "OmnitureKeyword",
        "OmnitureOwnerKeyword",
        "IsNotClickable"
})

public class Banner {

    @JsonProperty("Id")
    private String id;
    @JsonProperty("ImageUrl")
    private String imageUrl;
    @JsonProperty("DeeplinkUrl")
    private String deeplinkUrl;
    @JsonProperty("OmnitureKeyword")
    private String omnitureKeyword;
    @JsonProperty("OmnitureOwnerKeyword")
    private String omnitureOwnerKeyword;
    @JsonProperty("IsNotClickable")
    private Boolean isNotClickable;

    @JsonProperty("Id")
    public String getId() {
        return id;
    }

    @JsonProperty("Id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("ImageUrl")
    public String getImageUrl() {
        return imageUrl;
    }

    @JsonProperty("ImageUrl")
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @JsonProperty("DeeplinkUrl")
    public String getDeeplinkUrl() {
        return deeplinkUrl;
    }

    @JsonProperty("DeeplinkUrl")
    public void setDeeplinkUrl(String deeplinkUrl) {
        this.deeplinkUrl = deeplinkUrl;
    }

    @JsonProperty("OmnitureKeyword")
    public String getOmnitureKeyword() {
        return omnitureKeyword;
    }

    @JsonProperty("OmnitureKeyword")
    public void setOmnitureKeyword(String omnitureKeyword) {
        this.omnitureKeyword = omnitureKeyword;
    }

    @JsonProperty("OmnitureOwnerKeyword")
    public String getOmnitureOwnerKeyword() {
        return omnitureOwnerKeyword;
    }

    @JsonProperty("OmnitureOwnerKeyword")
    public void setOmnitureOwnerKeyword(String omnitureOwnerKeyword) {
        this.omnitureOwnerKeyword = omnitureOwnerKeyword;
    }

    @JsonProperty("IsNotClickable")
    public Boolean getIsNotClickable() {
        return isNotClickable;
    }

    @JsonProperty("IsNotClickable")
    public void setIsNotClickable(Boolean isNotClickable) {
        this.isNotClickable = isNotClickable;
    }

}
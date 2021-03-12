package apiEngine.models.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "CdnImageUrl",
        "SeoUrl"
})
public class Banner {

    @JsonProperty("CdnImageUrl")
    private String cdnImageUrl;
    @JsonProperty("SeoUrl")
    private String seoUrl;

    @JsonProperty("CdnImageUrl")
    public String getCdnImageUrl() {
        return cdnImageUrl;
    }

    @JsonProperty("CdnImageUrl")
    public void setCdnImageUrl(String cdnImageUrl) {
        this.cdnImageUrl = cdnImageUrl;
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

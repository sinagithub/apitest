package apiEngine.models.response;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Banners"
})
public class HomePageBannerData {

    @JsonProperty("Banners")
    private List<Banner> banners = null;

    @JsonProperty("Banners")
    public List<Banner> getBanners() {
        return banners;
    }

    @JsonProperty("Banners")
    public void setBanners(List<Banner> banners) {
        this.banners = banners;
    }

}
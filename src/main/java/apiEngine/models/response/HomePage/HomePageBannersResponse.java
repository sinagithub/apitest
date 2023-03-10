package apiEngine.models.response.HomePage;

import java.util.List;

import apiEngine.models.response.Info;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonPropertyOrder({
        "Version",
        "InfoList",
        "Data"
})
public class HomePageBannersResponse {

    @JsonProperty("Version")
    private String version;
    @JsonProperty("InfoList")
    private List<Info> info = null;
    @JsonProperty("Data")
    private HomePageBannerData homePageBannerData;

    @JsonProperty("Version")
    public String getVersion() {
        return version;
    }

    @JsonProperty("Version")
    public void setVersion(String version) {
        this.version = version;
    }

    @JsonProperty("InfoList")
    public List<Info> getInfoList() {
        return info;
    }

    @JsonProperty("InfoList")
    public void setInfoList(List<Info> info) {
        this.info = info;
    }

    @JsonProperty("Data")
    public HomePageBannerData getData() {
        return homePageBannerData;
    }

    @JsonProperty("Data")
    public void setData(HomePageBannerData homePageBannerData) {
        this.homePageBannerData = homePageBannerData;
    }

}

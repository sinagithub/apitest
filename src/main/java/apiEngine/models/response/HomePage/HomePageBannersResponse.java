package apiEngine.models.response.HomePage;

import java.util.List;

import apiEngine.models.response.InfoList;
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
    private List<InfoList> infoList = null;
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
    public List<InfoList> getInfoList() {
        return infoList;
    }

    @JsonProperty("InfoList")
    public void setInfoList(List<InfoList> infoList) {
        this.infoList = infoList;
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

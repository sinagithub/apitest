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
public class HomePageBanabiResponse {

    @JsonProperty("Version")
    private String version;
    @JsonProperty("InfoList")
    private List<InfoList> infoList = null;
    @JsonProperty("Data")
    private HomePageBanabiData homePageBanabiData;

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
    public HomePageBanabiData getData() {
        return homePageBanabiData;
    }

    @JsonProperty("Data")
    public void setData(HomePageBanabiData homePageBanabiData) {
        this.homePageBanabiData = homePageBanabiData;
    }

}
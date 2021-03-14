package apiEngine.models.response;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Data",
        "Version",
        "InfoList"
})
public class HomePageCarsiResponse {

    @JsonProperty("Data")
    private HomePageCarsiData homePageCarsiData;
    @JsonProperty("Version")
    private String version;
    @JsonProperty("InfoList")
    private List<Object> infoList = null;

    @JsonProperty("Data")
    public HomePageCarsiData getData() {
        return homePageCarsiData;
    }

    @JsonProperty("Data")
    public void setData(HomePageCarsiData homePageCarsiData) {
        this.homePageCarsiData = homePageCarsiData;
    }

    @JsonProperty("Version")
    public String getVersion() {
        return version;
    }

    @JsonProperty("Version")
    public void setVersion(String version) {
        this.version = version;
    }

    @JsonProperty("InfoList")
    public List<Object> getInfoList() {
        return infoList;
    }

    @JsonProperty("InfoList")
    public void setInfoList(List<Object> infoList) {
        this.infoList = infoList;
    }

}
package apiEngine.models.response.Splash;

import apiEngine.models.response.InfoList;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class SplashResponse {

    @JsonProperty("Version")
    private String version;
    @JsonProperty("InfoList")
    private List<InfoList> infoList = null;
    @JsonProperty("Data")
    private SplashData data;

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
    public SplashData getData() {
        return data;
    }

    @JsonProperty("Data")
    public void setData(SplashData data) {
        this.data = data;
    }
}
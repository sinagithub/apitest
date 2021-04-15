package apiEngine.models.response.Splash;

import apiEngine.models.response.Info;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class SplashResponse {

    @JsonProperty("Version")
    private String version;
    @JsonProperty("InfoList")
    private List<Info> info = null;
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
    public List<Info> getInfoList() {
        return info;
    }

    @JsonProperty("InfoList")
    public void setInfoList(List<Info> info) {
        this.info = info;
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
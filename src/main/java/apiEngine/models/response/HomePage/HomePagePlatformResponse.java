package apiEngine.models.response.HomePage;

import java.util.List;

import apiEngine.models.response.InfoList;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


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
public class HomePagePlatformResponse {

    @JsonProperty("Data")
    private List<PlatformData> data = null;
    @JsonProperty("Version")
    private String version;
    @JsonProperty("InfoList")
    private List<Object> infoList = null;

    @JsonProperty("Data")
    public List<PlatformData> getData() {
        return data;
    }

    @JsonProperty("Data")
    public void setData(List<PlatformData> data) {
        this.data = data;
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

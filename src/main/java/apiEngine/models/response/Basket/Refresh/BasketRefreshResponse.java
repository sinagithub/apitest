package apiEngine.models.response.Basket.Refresh;


import javax.annotation.Generated;

import apiEngine.models.response.Info;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Version",
        "InfoList",
        "Data"
})
@Generated("jsonschema2pojo")
public class BasketRefreshResponse {

    @JsonProperty("Version")
    private String version;
    @JsonProperty("InfoList")
    private List<Info> infoList = null;
    @JsonProperty("Data")
    private List<Datum> data = null;

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
        return infoList;
    }

    @JsonProperty("InfoList")
    public void setInfoList(List<Info> infoList) {
        this.infoList = infoList;
    }

    @JsonProperty("Data")
    public List<Datum> getData() {
        return data;
    }

    @JsonProperty("Data")
    public void setData(List<Datum> data) {
        this.data = data;
    }

}
package apiEngine.models.response.Basket;

import java.util.List;

import apiEngine.models.response.Info;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Version",
        "InfoList",
        "Data"
})
public class DeleteBasketResponse {

    @JsonProperty("Version")
    private String version;
    @JsonProperty("InfoList")
    private List<Info> info = null;
    @JsonProperty("Data")
    private Boolean data;

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
    public Boolean getData() {
        return data;
    }

    @JsonProperty("Data")
    public void setData(Boolean data) {
        this.data = data;
    }

}


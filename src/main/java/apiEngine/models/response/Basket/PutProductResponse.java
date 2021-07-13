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

public class PutProductResponse {

    @JsonProperty("Version")
    private String version;
    @JsonProperty("InfoList")
    private List<Info> infoList = null;
    @JsonProperty("Data")
    private PutProductData data;

    /**
     * No args constructor for use in serialization
     */
    public PutProductResponse() {
    }

    /**
     * @param data
     * @param infoList
     * @param version
     */
    public PutProductResponse(String version, List<Info> infoList, PutProductData data) {
        super();
        this.version = version;
        this.infoList = infoList;
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
    public List<Info> getInfoList() {
        return infoList;
    }

    @JsonProperty("InfoList")
    public void setInfoList(List<Info> infoList) {
        this.infoList = infoList;
    }

    @JsonProperty("Data")
    public PutProductData getData() {
        return data;
    }

    @JsonProperty("Data")
    public void setData(PutProductData data) {
        this.data = data;
    }

}

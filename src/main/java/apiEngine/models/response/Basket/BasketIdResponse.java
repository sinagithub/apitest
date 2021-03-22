package apiEngine.models.response.Basket;

import apiEngine.models.response.InfoList;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Data",
        "Version",
        "InfoList"
})
public class BasketIdResponse {

    @JsonProperty("Data")
    private String basketId;
    @JsonProperty("Version")
    private String version;
    @JsonProperty("InfoList")
    private List<InfoList> infoList = null;

    @JsonProperty("Data")
    public String getBasketId() {
        return basketId;
    }

    @JsonProperty("Data")
    public void setBasketId(String basketId) {
        this.basketId = basketId;
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
    public List<InfoList> getInfoList() {
        return infoList;
    }

    @JsonProperty("InfoList")
    public void setInfoList(List<InfoList> infoList) {
        this.infoList = infoList;
    }

}

package apiEngine.models.response.Favorite;

import apiEngine.models.response.Info;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;


@JsonPropertyOrder({
        "Version",
        "InfoList",
        "Message"
})

public class VendorDeleteFavoriteResponse {

    @JsonProperty("Version")
    private String version;
    @JsonProperty("InfoList")
    private List<Info> infoList = null;
    @JsonProperty("Message")
    private String message;

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

    @JsonProperty("Message")
    public String getMessage() {
        return message;
    }

    @JsonProperty("Message")
    public void setMessage(String message) {
        this.message = message;
    }

}

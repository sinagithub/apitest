package apiEngine.models.response.Favorite;

import java.util.List;
import javax.annotation.Generated;

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
@Generated("jsonschema2pojo")
public class VendorFavoriteResponse {

    @JsonProperty("Version")
    private String version;
    @JsonProperty("InfoList")
    private List<Info> infoList = null;
    @JsonProperty("Data")
    private VendorFavoriteData vendorFavoriteData;

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
    public VendorFavoriteData getData() {
        return vendorFavoriteData;
    }

    @JsonProperty("Data")
    public void setData(VendorFavoriteData vendorFavoriteData) {
        this.vendorFavoriteData = vendorFavoriteData;
    }

}

package apiEngine.models.response.Vendor;

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

public class VendorResponse {

    @JsonProperty("Version")
    private String version;
    @JsonProperty("InfoList")
    private List<Info> infoList = null;
    @JsonProperty("Data")
    private VendorData vendorData;

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
    public VendorData getData() {
        return vendorData;
    }

    @JsonProperty("Data")
    public void setData(VendorData vendorData) {
        this.vendorData = vendorData;
    }

}

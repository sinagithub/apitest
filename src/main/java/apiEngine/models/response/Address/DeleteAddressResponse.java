package apiEngine.models.response.Address;


import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Data",
        "InfoList"
})

public class DeleteAddressResponse {
    @JsonProperty("Data")
    private Boolean data;
    @JsonProperty("InfoList")
    private List<AddressInfo> infoList = null;

    @JsonProperty("Data")
    public Boolean getData() {
        return data;
    }

    @JsonProperty("Data")
    public void setData(Boolean data) {
        this.data = data;
    }

    @JsonProperty("InfoList")
    public List<AddressInfo> getInfoList() {
        return infoList;
    }

    @JsonProperty("InfoList")
    public void setInfoList(List<AddressInfo> infoList) {
        this.infoList = infoList;
    }
}

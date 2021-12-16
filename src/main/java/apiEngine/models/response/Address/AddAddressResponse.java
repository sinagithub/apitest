package apiEngine.models.response.Address;

import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Data",
        "InfoList"
})

public class AddAddressResponse {

    @JsonProperty("Data")
    private String data;
    @JsonProperty("InfoList")
    private List<AddressInfo> infoList = null;

    @JsonProperty("Data")
    public String getData() {
        return data;
    }

    @JsonProperty("Data")
    public void setData(String data) {
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

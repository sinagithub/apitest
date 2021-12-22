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

public class AddressDetailResponse {
    @JsonProperty("Data")
    private AddressDetail addressDetail;
    @JsonProperty("InfoList")
    private List<Object> infoList = null;

    @JsonProperty("Data")
    public AddressDetail getData() {
        return addressDetail;
    }

    @JsonProperty("Data")
    public void setData(AddressDetail addressDetail) {
        this.addressDetail = addressDetail;
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

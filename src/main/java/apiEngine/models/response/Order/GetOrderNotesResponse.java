package apiEngine.models.response.Order;

import java.util.List;

import apiEngine.models.response.Info;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Data",
        "InfoList"
})

public class GetOrderNotesResponse {

    @JsonProperty("Data")
    private List<GetOrderNoteData> data = null;
    @JsonProperty("InfoList")
    private List<Info> infoList = null;

    @JsonProperty("Data")
    public List<GetOrderNoteData> getData() {
        return data;
    }

    @JsonProperty("Data")
    public void setData(List<GetOrderNoteData> data) {
        this.data = data;
    }

    @JsonProperty("InfoList")
    public List<Info> getInfoList() {
        return infoList;
    }

    @JsonProperty("InfoList")
    public void setInfoList(List<Info> infoList) {
        this.infoList = infoList;
    }

}

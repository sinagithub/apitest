package apiEngine.models.response.Content;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Data",
        "InfoList"
})

public class FaqResponse {

    @JsonProperty("Data")
    private List<FaqData> data = null;
    @JsonProperty("InfoList")
    private List<Object> infoList = null;

    @JsonProperty("Data")
    public List<FaqData> getData() {
        return data;
    }

    @JsonProperty("Data")
    public void setData(List<FaqData> data) {
        this.data = data;
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

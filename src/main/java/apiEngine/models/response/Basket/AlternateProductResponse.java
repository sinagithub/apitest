package apiEngine.models.response.Basket;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Data",
        "InfoList"
})

public class AlternateProductResponse {

    @JsonProperty("Data")
    private AlternateOptionData alternateOptionData;
    @JsonProperty("InfoList")
    private List<Object> infoList = null;

    @JsonProperty("Data")
    public AlternateOptionData getData() {
        return alternateOptionData;
    }

    @JsonProperty("Data")
    public void setData(AlternateOptionData alternateOptionData) {
        this.alternateOptionData = alternateOptionData;
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

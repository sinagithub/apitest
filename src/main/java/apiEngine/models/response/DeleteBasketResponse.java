package apiEngine.models.response;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.cucumber.java.sl.In;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Data",
        "InfoList"
})


public class DeleteBasketResponse {

    @JsonProperty("Data")
    private Boolean data;
    @JsonProperty("InfoList")
    private List<Info> infoList = null;

    @JsonProperty("Data")
    public Boolean getData() {
        return data;
    }

    @JsonProperty("Data")
    public void setData(Boolean data) {
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
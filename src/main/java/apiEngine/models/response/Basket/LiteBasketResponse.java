package apiEngine.models.response.Basket;

import java.util.List;
import apiEngine.models.response.Info;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
        "Data",
        "InfoList"
})

public class LiteBasketResponse {

    @JsonProperty("Data")
    private LiteBasketData liteBasketData;
    @JsonProperty("InfoList")
    private List<Info> infoList = null;

    @JsonProperty("Data")
    public LiteBasketData getData() {
        return liteBasketData;
    }

    @JsonProperty("Data")
    public void setData(LiteBasketData liteBasketData) {
        this.liteBasketData = liteBasketData;
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

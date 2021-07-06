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

public class BasketResponse {

    @JsonProperty("Data")
    private BasketData data;
    @JsonProperty("InfoList")
    private List<Object> infoList = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public BasketResponse() {
    }

    /**
     *
     * @param data
     * @param infoList
     */
    public BasketResponse(BasketData data, List<Object> infoList) {
        super();
        this.data = data;
        this.infoList = infoList;
    }

    @JsonProperty("Data")
    public BasketData getData() {
        return data;
    }

    @JsonProperty("Data")
    public void setData(BasketData data) {
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
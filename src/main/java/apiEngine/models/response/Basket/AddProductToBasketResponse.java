package apiEngine.models.response.Basket;

import java.util.List;
import javax.annotation.Generated;

import apiEngine.models.response.Info;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.cucumber.java.sl.In;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Data",
        "InfoList"
})
@Generated("jsonschema2pojo")
public class AddProductToBasketResponse {

    @JsonProperty("Data")
    private AddBasketData addBasketData;
    @JsonProperty("InfoList")
    private List<Info> infoList = null;

    @JsonProperty("Data")
    public AddBasketData getData() {
        return addBasketData;
    }

    @JsonProperty("Data")
    public void setData(AddBasketData addBasketData) {
        this.addBasketData = addBasketData;
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

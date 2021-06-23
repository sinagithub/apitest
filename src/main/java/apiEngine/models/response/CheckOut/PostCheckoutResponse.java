package apiEngine.models.response.CheckOut;

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
@Generated("jsonschema2pojo")
public class PostCheckoutResponse {

    @JsonProperty("Data")
    private PostCheckOutData postCheckOutData;
    @JsonProperty("InfoList")
    private List<Object> infoList = null;

    @JsonProperty("Data")
    public PostCheckOutData getData() {
        return postCheckOutData;
    }

    @JsonProperty("Data")
    public void setData(PostCheckOutData postCheckOutData) {
        this.postCheckOutData = postCheckOutData;
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

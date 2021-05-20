package apiEngine.models.response.Payment;

import java.util.List;
import javax.annotation.Generated;

import apiEngine.models.response.Info;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonPropertyOrder({
        "Data",
        "InfoList"
})
@Generated("jsonschema2pojo")
public class UserCardsResponse {

    @JsonProperty("Data")
    private UserCardData userCardData;
    @JsonProperty("InfoList")
    private List<Info> infoList = null;

    @JsonProperty("Data")
    public UserCardData getData() {
        return userCardData;
    }

    @JsonProperty("Data")
    public void setData(UserCardData userCardData) {
        this.userCardData = userCardData;
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

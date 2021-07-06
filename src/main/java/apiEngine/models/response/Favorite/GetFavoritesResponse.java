package apiEngine.models.response.Favorite;

import apiEngine.models.response.Info;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Data",
        "InfoList"
})

public class GetFavoritesResponse {

    @JsonProperty("Data")
    private FavoriteData data;
    @JsonProperty("InfoList")
    private List<Info> infoList = null;

    @JsonProperty("Data")
    public FavoriteData getData() {
        return data;
    }

    @JsonProperty("Data")
    public void setData(FavoriteData data) {
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
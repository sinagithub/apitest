package apiEngine.models.response.Favorite;

import apiEngine.models.response.Info;
import apiEngine.models.response.ProductDetail.Data;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "InfoList",
        "Data"
})

public class GetFavoritesResponse {

    @JsonProperty("InfoList")
    private List<Info> infoList = null;
    @JsonProperty("Data")
    private FavoriteData data;

    @JsonProperty("InfoList")
    public List<Info> getInfoList() {
        return infoList;
    }

    @JsonProperty("InfoList")
    public void setInfoList(List<Info> infoList) {
        this.infoList = infoList;
    }

    @JsonProperty("Data")
    public FavoriteData getData() {
        return data;
    }

    @JsonProperty("Data")
    public void setData(FavoriteData data) {
        this.data = data;
    }

}
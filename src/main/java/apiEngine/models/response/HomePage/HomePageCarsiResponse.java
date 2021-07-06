package apiEngine.models.response.HomePage;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Data"
})

public class HomePageCarsiResponse {

    @JsonProperty("Data")
    private HomePageCarsiData data;

    @JsonProperty("Data")
    public HomePageCarsiData getData() {
        return data;
    }

    @JsonProperty("Data")
    public void setData(HomePageCarsiData data) {
        this.data = data;
    }

}
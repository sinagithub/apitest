package apiEngine.models.response;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "CarsiCategories"
})
public class CarsiCategoryData {

    @JsonProperty("CarsiCategories")
    private List<CarsiCategories> carsiCategories = null;

    @JsonProperty("CarsiCategories")
    public List<CarsiCategories> getCarsiCategories() {
        return carsiCategories;
    }

    @JsonProperty("CarsiCategories")
    public void setCarsiCategories(List<CarsiCategories> carsiCategories) {
        this.carsiCategories = carsiCategories;
    }

}

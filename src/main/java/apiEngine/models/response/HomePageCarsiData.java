package apiEngine.models.response;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "CarsiCategories",
        "CarsiVendors"
})
public class HomePageCarsiData {

    @JsonProperty("CarsiCategories")
    private List<CarsiCategory> carsiCategories = null;
    @JsonProperty("CarsiVendors")
    private List<CarsiVendor> carsiVendors = null;

    @JsonProperty("CarsiCategories")
    public List<CarsiCategory> getCarsiCategories() {
        return carsiCategories;
    }

    @JsonProperty("CarsiCategories")
    public void setCarsiCategories(List<CarsiCategory> carsiCategories) {
        this.carsiCategories = carsiCategories;
    }

    @JsonProperty("CarsiVendors")
    public List<CarsiVendor> getCarsiVendors() {
        return carsiVendors;
    }

    @JsonProperty("CarsiVendors")
    public void setCarsiVendors(List<CarsiVendor> carsiVendors) {
        this.carsiVendors = carsiVendors;
    }

}
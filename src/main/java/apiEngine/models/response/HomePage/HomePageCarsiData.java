package apiEngine.models.response.HomePage;

import java.util.List;

import apiEngine.models.response.CarsiCategory;
import apiEngine.models.response.CarsiVendor;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


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
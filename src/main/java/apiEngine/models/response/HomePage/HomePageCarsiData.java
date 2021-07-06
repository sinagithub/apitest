package apiEngine.models.response.HomePage;

import java.util.List;


import apiEngine.models.response.MahalleCategory;
import apiEngine.models.response.MahalleVendor;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "MahalleCategories",
        "MahalleVendors"
})

public class HomePageCarsiData {

    @JsonProperty("MahalleCategories")
    private List<MahalleCategory> carsiCategories = null;
    @JsonProperty("MahalleVendors")
    private List<MahalleVendor> mahalleVendors = null;

    @JsonProperty("MahalleCategories")
    public List<MahalleCategory> getCarsiCategories() {
        return carsiCategories;
    }

    @JsonProperty("MahalleCategories")
    public void setCarsiCategories(List<MahalleCategory> carsiCategories) {
        this.carsiCategories = carsiCategories;
    }

    @JsonProperty("MahalleVendors")
    public List<MahalleVendor> getCarsiVendors() {
        return mahalleVendors;
    }

    @JsonProperty("MahalleVendors")
    public void setCarsiVendors(List<MahalleVendor> mahalleVendors) {
        this.mahalleVendors = mahalleVendors;
    }

}
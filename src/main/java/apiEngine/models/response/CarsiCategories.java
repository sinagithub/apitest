package apiEngine.models.response;


import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "CategoryName",
        "CategoryId",
        "CarsiVendors"
})
public class CarsiCategories {

    @JsonProperty("CategoryName")
    private String categoryName;
    @JsonProperty("CategoryId")
    private Integer categoryId;
    @JsonProperty("CarsiVendors")
    private List<CarsiVendors> carsiVendors = null;

    @JsonProperty("CategoryName")
    public String getCategoryName() {
        return categoryName;
    }

    @JsonProperty("CategoryName")
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @JsonProperty("CategoryId")
    public Integer getCategoryId() {
        return categoryId;
    }

    @JsonProperty("CategoryId")
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    @JsonProperty("CarsiVendors")
    public List<CarsiVendors> getCarsiVendors() {
        return carsiVendors;
    }

    @JsonProperty("CarsiVendors")
    public void setCarsiVendors(List<CarsiVendors> carsiVendors) {
        this.carsiVendors = carsiVendors;
    }

}
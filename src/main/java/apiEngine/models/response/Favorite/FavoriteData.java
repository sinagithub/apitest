package apiEngine.models.response.Favorite;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Vendors"
})

public class FavoriteData {

    @JsonProperty("Vendors")
    private List<Vendor> vendors = null;

    @JsonProperty("Vendors")
    public List<Vendor> getVendors() {
        return vendors;
    }

    @JsonProperty("Vendors")
    public void setVendors(List<Vendor> vendors) {
        this.vendors = vendors;
    }
}
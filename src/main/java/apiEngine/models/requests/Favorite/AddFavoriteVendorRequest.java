package apiEngine.models.requests.Favorite;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonPropertyOrder({
        "VendorId"
})

public class AddFavoriteVendorRequest {

    @JsonProperty("VendorId")
    private String vendorId;

    /**
     * No args constructor for use in serialization
     *
     */
    public AddFavoriteVendorRequest() {
    }

    /**
     *
     * @param vendorId
     */
    public AddFavoriteVendorRequest(String vendorId) {
        super();
        this.vendorId = vendorId;
    }

    @JsonProperty("VendorId")
    public String getVendorId() {
        return vendorId;
    }

    @JsonProperty("VendorId")
    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

}

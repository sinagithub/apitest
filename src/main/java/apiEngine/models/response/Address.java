package apiEngine.models.response;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Address {
    @JsonProperty("AddressId")
    public String addressId;
    @JsonProperty("AreaId")
    public String areaId;
    @JsonProperty("AddressLine1")
    public String addressLine1;
    @JsonProperty("AddressName")
    public String addressName;
    @JsonProperty("AddressType")
    public Integer addressType;
    @JsonProperty("City")
    public String city;
    @JsonProperty("Description")
    public String description;
    @JsonProperty("Email")
    public String email;
    @JsonProperty("AreaName")
    public String areaName;
    @JsonProperty("TelephoneNumber")
    public String telephoneNumber;
    @JsonProperty("MobileTelephoneNumber")
    public String mobileTelephoneNumber;
    @JsonProperty("Latitude")
    public Double latitude;
    @JsonProperty("Longitude")
    public Double longitude;
    @JsonProperty("FromAutoComplete")
    public Boolean fromAutoComplete;
    @JsonProperty("Selected")
    public Boolean selected;
    @JsonProperty("FirstName")
    public String firstName;
    @JsonProperty("LastName")
    public String lastName;
    @JsonProperty("Organization")
    public String organization;
    @JsonProperty("AvailabilityStatus")
    public Integer availabilityStatus;
    @JsonProperty("AvailabilityStatusText")
    public String availabilityStatusText;
    @JsonProperty("StoreId")
    public String storeId;
}

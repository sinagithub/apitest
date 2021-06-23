package apiEngine.models.response.Address;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "IsAvailable",
        "AddressId",
        "AddressLine1",
        "AddressName",
        "AddressType",
        "City",
        "Description",
        "Email",
        "FirstName",
        "LastName",
        "MobileTelephoneNumber",
        "Organization",
        "AreaId",
        "AreaName",
        "TelephoneNumber",
        "Selected",
        "ReadOnly",
        "Latitude",
        "Longitude",
        "FromAutoComplete"
})
@Generated("jsonschema2pojo")
public class AvailableAddressData {

    @JsonProperty("IsAvailable")
    private Boolean isAvailable;
    @JsonProperty("AddressId")
    private String addressId;
    @JsonProperty("AddressLine1")
    private String addressLine1;
    @JsonProperty("AddressName")
    private String addressName;
    @JsonProperty("AddressType")
    private Integer addressType;
    @JsonProperty("City")
    private String city;
    @JsonProperty("Description")
    private String description;
    @JsonProperty("Email")
    private String email;
    @JsonProperty("FirstName")
    private String firstName;
    @JsonProperty("LastName")
    private String lastName;
    @JsonProperty("MobileTelephoneNumber")
    private String mobileTelephoneNumber;
    @JsonProperty("Organization")
    private String organization;
    @JsonProperty("AreaId")
    private String areaId;
    @JsonProperty("AreaName")
    private String areaName;
    @JsonProperty("TelephoneNumber")
    private String telephoneNumber;
    @JsonProperty("Selected")
    private Boolean selected;
    @JsonProperty("ReadOnly")
    private Boolean readOnly;
    @JsonProperty("Latitude")
    private Double latitude;
    @JsonProperty("Longitude")
    private Double longitude;
    @JsonProperty("FromAutoComplete")
    private Boolean fromAutoComplete;

    @JsonProperty("IsAvailable")
    public Boolean getIsAvailable() {
        return isAvailable;
    }

    @JsonProperty("IsAvailable")
    public void setIsAvailable(Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    @JsonProperty("AddressId")
    public String getAddressId() {
        return addressId;
    }

    @JsonProperty("AddressId")
    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    @JsonProperty("AddressLine1")
    public String getAddressLine1() {
        return addressLine1;
    }

    @JsonProperty("AddressLine1")
    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    @JsonProperty("AddressName")
    public String getAddressName() {
        return addressName;
    }

    @JsonProperty("AddressName")
    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    @JsonProperty("AddressType")
    public Integer getAddressType() {
        return addressType;
    }

    @JsonProperty("AddressType")
    public void setAddressType(Integer addressType) {
        this.addressType = addressType;
    }

    @JsonProperty("City")
    public String getCity() {
        return city;
    }

    @JsonProperty("City")
    public void setCity(String city) {
        this.city = city;
    }

    @JsonProperty("Description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("Description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("Email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("Email")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("FirstName")
    public String getFirstName() {
        return firstName;
    }

    @JsonProperty("FirstName")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @JsonProperty("LastName")
    public String getLastName() {
        return lastName;
    }

    @JsonProperty("LastName")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @JsonProperty("MobileTelephoneNumber")
    public String getMobileTelephoneNumber() {
        return mobileTelephoneNumber;
    }

    @JsonProperty("MobileTelephoneNumber")
    public void setMobileTelephoneNumber(String mobileTelephoneNumber) {
        this.mobileTelephoneNumber = mobileTelephoneNumber;
    }

    @JsonProperty("Organization")
    public String getOrganization() {
        return organization;
    }

    @JsonProperty("Organization")
    public void setOrganization(String organization) {
        this.organization = organization;
    }

    @JsonProperty("AreaId")
    public String getAreaId() {
        return areaId;
    }

    @JsonProperty("AreaId")
    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    @JsonProperty("AreaName")
    public String getAreaName() {
        return areaName;
    }

    @JsonProperty("AreaName")
    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    @JsonProperty("TelephoneNumber")
    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    @JsonProperty("TelephoneNumber")
    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    @JsonProperty("Selected")
    public Boolean getSelected() {
        return selected;
    }

    @JsonProperty("Selected")
    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    @JsonProperty("ReadOnly")
    public Boolean getReadOnly() {
        return readOnly;
    }

    @JsonProperty("ReadOnly")
    public void setReadOnly(Boolean readOnly) {
        this.readOnly = readOnly;
    }

    @JsonProperty("Latitude")
    public Double getLatitude() {
        return latitude;
    }

    @JsonProperty("Latitude")
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    @JsonProperty("Longitude")
    public Double getLongitude() {
        return longitude;
    }

    @JsonProperty("Longitude")
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @JsonProperty("FromAutoComplete")
    public Boolean getFromAutoComplete() {
        return fromAutoComplete;
    }

    @JsonProperty("FromAutoComplete")
    public void setFromAutoComplete(Boolean fromAutoComplete) {
        this.fromAutoComplete = fromAutoComplete;
    }

}

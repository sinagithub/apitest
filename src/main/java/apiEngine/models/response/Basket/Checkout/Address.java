package apiEngine.models.response.Basket.Checkout;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
        "Id",
        "Description",
        "AddressType",
        "Latitude",
        "Longitude",
        "PhoneNumber",
        "MobilePhoneNumber",
        "FirstName",
        "LastName",
        "Email",
        "Organization",
        "City",
        "AreaId",
        "AreaName",
        "AddressLine",
        "IsSelected"
})

public class Address {

    @JsonProperty("Id")
    private String id;
    @JsonProperty("Description")
    private String description;
    @JsonProperty("AddressType")
    private Integer addressType;
    @JsonProperty("Latitude")
    private Double latitude;
    @JsonProperty("Longitude")
    private Double longitude;
    @JsonProperty("PhoneNumber")
    private String phoneNumber;
    @JsonProperty("MobilePhoneNumber")
    private String mobilePhoneNumber;
    @JsonProperty("FirstName")
    private String firstName;
    @JsonProperty("LastName")
    private String lastName;
    @JsonProperty("Email")
    private String email;
    @JsonProperty("Organization")
    private String organization;
    @JsonProperty("City")
    private String city;
    @JsonProperty("AreaId")
    private String areaId;
    @JsonProperty("AreaName")
    private String areaName;
    @JsonProperty("AddressLine")
    private String addressLine;
    @JsonProperty("IsSelected")
    private Boolean isSelected;

    @JsonProperty("Id")
    public String getId() {
        return id;
    }

    @JsonProperty("Id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("Description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("Description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("AddressType")
    public Integer getAddressType() {
        return addressType;
    }

    @JsonProperty("AddressType")
    public void setAddressType(Integer addressType) {
        this.addressType = addressType;
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

    @JsonProperty("PhoneNumber")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @JsonProperty("PhoneNumber")
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @JsonProperty("MobilePhoneNumber")
    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    @JsonProperty("MobilePhoneNumber")
    public void setMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
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

    @JsonProperty("Email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("Email")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("Organization")
    public String getOrganization() {
        return organization;
    }

    @JsonProperty("Organization")
    public void setOrganization(String organization) {
        this.organization = organization;
    }

    @JsonProperty("City")
    public String getCity() {
        return city;
    }

    @JsonProperty("City")
    public void setCity(String city) {
        this.city = city;
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

    @JsonProperty("AddressLine")
    public String getAddressLine() {
        return addressLine;
    }

    @JsonProperty("AddressLine")
    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }

    @JsonProperty("IsSelected")
    public Boolean getIsSelected() {
        return isSelected;
    }

    @JsonProperty("IsSelected")
    public void setIsSelected(Boolean isSelected) {
        this.isSelected = isSelected;
    }

}

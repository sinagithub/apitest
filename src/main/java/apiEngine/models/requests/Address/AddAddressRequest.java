package apiEngine.models.requests.Address;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.HashMap;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "AddressLine1",
        "AddressName",
        "AddressType",
        "City",
        "Description",
        "Email",
        "FirstName",
        "LastName",
        "Latitude",
        "Longitude",
        "AreaId",
        "TelephoneNumber"
})

public class AddAddressRequest {

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
    @JsonProperty("Latitude")
    private Double latitude;
    @JsonProperty("Longitude")
    private Double longitude;
    @JsonProperty("AreaId")
    private String areaId;
    @JsonProperty("TelephoneNumber")
    private String telephoneNumber;


    /**
     *
     * @param firstName
     * @param lastName
     * @param areaId
     * @param telephoneNumber
     * @param city
     * @param addressType
     * @param latitude
     * @param addressLine1
     * @param description
     * @param addressName
     * @param email
     * @param longitude
     */
    public AddAddressRequest(String addressLine1, String addressName, Integer addressType, String city, String description, String email, String firstName, String lastName, Double  latitude, Double  longitude, String areaId, String telephoneNumber) {
        super();
        this.addressLine1 = addressLine1;
        this.addressName = addressName;
        this.addressType = addressType;
        this.city = city;
        this.description = description;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.latitude = latitude;
        this.longitude = longitude;
        this.areaId = areaId;
        this.telephoneNumber = telephoneNumber;
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

    @JsonProperty("AreaId")
    public String getAreaId() {
        return areaId;
    }

    @JsonProperty("AreaId")
    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    @JsonProperty("TelephoneNumber")
    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    @JsonProperty("TelephoneNumber")
    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

}
package apiEngine.models.requests.InternalVendor;

import java.util.List;


import apiEngine.models.response.MicroServices.InternalVendor.Category;
import apiEngine.models.response.MicroServices.InternalVendor.DeliveryType;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Name",
        "CityId",
        "AreaId",
        "Area",
        "Email",
        "Phone",
        "Address",
        "Latitude",
        "Longitude",
        "MinDeliveryMinutes",
        "MaxDeliveryMinutes",
        "MinBasketAmount",
        "MaxBasketCapacity",
        "DeliveryFee",
        "LogoUrl",
        "BrandImageUrl",
        "AcceptsFutureOrder",
        "IsTipAvailable",
        "DeliveryTypes",
        "Categories",
        "PaymentTypes",
        "OperatingUserId"
})

public class UpdateVendorRequest {

    @JsonProperty("Name")
    private String name;
    @JsonProperty("CityId")
    private String cityId;
    @JsonProperty("AreaId")
    private String areaId;
    @JsonProperty("Area")
    private String area;
    @JsonProperty("Email")
    private String email;
    @JsonProperty("Phone")
    private String phone;
    @JsonProperty("Address")
    private String address;
    @JsonProperty("Latitude")
    private Integer latitude;
    @JsonProperty("Longitude")
    private Integer longitude;
    @JsonProperty("MinDeliveryMinutes")
    private Integer minDeliveryMinutes;
    @JsonProperty("MaxDeliveryMinutes")
    private Integer maxDeliveryMinutes;
    @JsonProperty("MinBasketAmount")
    private Integer minBasketAmount;
    @JsonProperty("MaxBasketCapacity")
    private Integer maxBasketCapacity;
    @JsonProperty("DeliveryFee")
    private Double deliveryFee;
    @JsonProperty("LogoUrl")
    private String logoUrl;
    @JsonProperty("BrandImageUrl")
    private String brandImageUrl;
    @JsonProperty("AcceptsFutureOrder")
    private Boolean acceptsFutureOrder;
    @JsonProperty("IsTipAvailable")
    private Boolean isTipAvailable;
    @JsonProperty("DeliveryTypes")
    private List<DeliveryType> deliveryTypes = null;
    @JsonProperty("Categories")
    private List<Category> categories = null;
    @JsonProperty("PaymentTypes")
    private List<String> paymentTypes = null;
    @JsonProperty("OperatingUserId")
    private String operatingUserId;

    /**
     * No args constructor for use in serialization
     */
    public UpdateVendorRequest() {
    }

    /**
     * @param area
     * @param address
     * @param maxDeliveryMinutes
     * @param latitude
     * @param brandImageUrl
     * @param cityId
     * @param operatingUserId
     * @param logoUrl
     * @param maxBasketCapacity
     * @param areaId
     * @param deliveryFee
     * @param phone
     * @param minBasketAmount
     * @param name
     * @param isTipAvailable
     * @param minDeliveryMinutes
     * @param acceptsFutureOrder
     * @param categories
     * @param paymentTypes
     * @param email
     * @param longitude
     * @param deliveryTypes
     */
    public UpdateVendorRequest(String name, String cityId, String areaId, String area, String email, String phone,
                               String address, Integer latitude, Integer longitude, Integer minDeliveryMinutes,
                               Integer maxDeliveryMinutes, Integer minBasketAmount, Integer maxBasketCapacity,
                               Double deliveryFee, String logoUrl, String brandImageUrl, Boolean acceptsFutureOrder,
                               Boolean isTipAvailable, List<DeliveryType> deliveryTypes, List<Category> categories,
                               List<String> paymentTypes, String operatingUserId) {
        super();
        this.name = name;
        this.cityId = cityId;
        this.areaId = areaId;
        this.area = area;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.minDeliveryMinutes = minDeliveryMinutes;
        this.maxDeliveryMinutes = maxDeliveryMinutes;
        this.minBasketAmount = minBasketAmount;
        this.maxBasketCapacity = maxBasketCapacity;
        this.deliveryFee = deliveryFee;
        this.logoUrl = logoUrl;
        this.brandImageUrl = brandImageUrl;
        this.acceptsFutureOrder = acceptsFutureOrder;
        this.isTipAvailable = isTipAvailable;
        this.deliveryTypes = deliveryTypes;
        this.categories = categories;
        this.paymentTypes = paymentTypes;
        this.operatingUserId = operatingUserId;
    }

    @JsonProperty("Name")
    public String getName() {
        return name;
    }

    @JsonProperty("Name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("CityId")
    public String getCityId() {
        return cityId;
    }

    @JsonProperty("CityId")
    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    @JsonProperty("AreaId")
    public String getAreaId() {
        return areaId;
    }

    @JsonProperty("AreaId")
    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    @JsonProperty("Area")
    public String getArea() {
        return area;
    }

    @JsonProperty("Area")
    public void setArea(String area) {
        this.area = area;
    }

    @JsonProperty("Email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("Email")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("Phone")
    public String getPhone() {
        return phone;
    }

    @JsonProperty("Phone")
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @JsonProperty("Address")
    public String getAddress() {
        return address;
    }

    @JsonProperty("Address")
    public void setAddress(String address) {
        this.address = address;
    }

    @JsonProperty("Latitude")
    public Integer getLatitude() {
        return latitude;
    }

    @JsonProperty("Latitude")
    public void setLatitude(Integer latitude) {
        this.latitude = latitude;
    }

    @JsonProperty("Longitude")
    public Integer getLongitude() {
        return longitude;
    }

    @JsonProperty("Longitude")
    public void setLongitude(Integer longitude) {
        this.longitude = longitude;
    }

    @JsonProperty("MinDeliveryMinutes")
    public Integer getMinDeliveryMinutes() {
        return minDeliveryMinutes;
    }

    @JsonProperty("MinDeliveryMinutes")
    public void setMinDeliveryMinutes(Integer minDeliveryMinutes) {
        this.minDeliveryMinutes = minDeliveryMinutes;
    }

    @JsonProperty("MaxDeliveryMinutes")
    public Integer getMaxDeliveryMinutes() {
        return maxDeliveryMinutes;
    }

    @JsonProperty("MaxDeliveryMinutes")
    public void setMaxDeliveryMinutes(Integer maxDeliveryMinutes) {
        this.maxDeliveryMinutes = maxDeliveryMinutes;
    }

    @JsonProperty("MinBasketAmount")
    public Integer getMinBasketAmount() {
        return minBasketAmount;
    }

    @JsonProperty("MinBasketAmount")
    public void setMinBasketAmount(Integer minBasketAmount) {
        this.minBasketAmount = minBasketAmount;
    }

    @JsonProperty("MaxBasketCapacity")
    public Integer getMaxBasketCapacity() {
        return maxBasketCapacity;
    }

    @JsonProperty("MaxBasketCapacity")
    public void setMaxBasketCapacity(Integer maxBasketCapacity) {
        this.maxBasketCapacity = maxBasketCapacity;
    }

    @JsonProperty("DeliveryFee")
    public Double getDeliveryFee() {
        return deliveryFee;
    }

    @JsonProperty("DeliveryFee")
    public void setDeliveryFee(Double deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    @JsonProperty("LogoUrl")
    public String getLogoUrl() {
        return logoUrl;
    }

    @JsonProperty("LogoUrl")
    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    @JsonProperty("BrandImageUrl")
    public String getBrandImageUrl() {
        return brandImageUrl;
    }

    @JsonProperty("BrandImageUrl")
    public void setBrandImageUrl(String brandImageUrl) {
        this.brandImageUrl = brandImageUrl;
    }

    @JsonProperty("AcceptsFutureOrder")
    public Boolean getAcceptsFutureOrder() {
        return acceptsFutureOrder;
    }

    @JsonProperty("AcceptsFutureOrder")
    public void setAcceptsFutureOrder(Boolean acceptsFutureOrder) {
        this.acceptsFutureOrder = acceptsFutureOrder;
    }

    @JsonProperty("IsTipAvailable")
    public Boolean getIsTipAvailable() {
        return isTipAvailable;
    }

    @JsonProperty("IsTipAvailable")
    public void setIsTipAvailable(Boolean isTipAvailable) {
        this.isTipAvailable = isTipAvailable;
    }

    @JsonProperty("DeliveryTypes")
    public List<DeliveryType> getDeliveryTypes() {
        return deliveryTypes;
    }

    @JsonProperty("DeliveryTypes")
    public void setDeliveryTypes(List<DeliveryType> deliveryTypes) {
        this.deliveryTypes = deliveryTypes;
    }

    @JsonProperty("Categories")
    public List<Category> getCategories() {
        return categories;
    }

    @JsonProperty("Categories")
    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    @JsonProperty("PaymentTypes")
    public List<String> getPaymentTypes() {
        return paymentTypes;
    }

    @JsonProperty("PaymentTypes")
    public void setPaymentTypes(List<String> paymentTypes) {
        this.paymentTypes = paymentTypes;
    }

    @JsonProperty("OperatingUserId")
    public String getOperatingUserId() {
        return operatingUserId;
    }

    @JsonProperty("OperatingUserId")
    public void setOperatingUserId(String operatingUserId) {
        this.operatingUserId = operatingUserId;
    }

}

package apiEngine.models.response.MicroServices.InternalVendor;


import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Id",
        "Name",
        "City",
        "Area",
        "Email",
        "Phone",
        "Address",
        "Latitude",
        "Longitude",
        "MinDeliveryMinutes",
        "MaxDeliveryMinutes",
        "DeliveryTime",
        "MinBasketAmount",
        "MinBasketAmountText",
        "MaxBasketCapacity",
        "DeliveryFee",
        "DeliveryFeeText",
        "DeliveryInterval",
        "LogoUrl",
        "BrandImageUrl",
        "BackgroundUrl",
        "CategoryName",
        "AcceptsFutureOrder",
        "IsTipAvailable",
        "DeliveryTypeId",
        "DeliveryType",
        "IsOpen",
        "Categories",
        "DeliveryTypes",
        "PaymentTypes",
        "WorkingHours"
})
@Generated("jsonschema2pojo")
public class InternalVendorDetailResponse {

    @JsonProperty("Id")
    private String id;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("City")
    private String city;
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
    @JsonProperty("DeliveryTime")
    private String deliveryTime;
    @JsonProperty("MinBasketAmount")
    private Integer minBasketAmount;
    @JsonProperty("MinBasketAmountText")
    private String minBasketAmountText;
    @JsonProperty("MaxBasketCapacity")
    private Integer maxBasketCapacity;
    @JsonProperty("DeliveryFee")
    private Double deliveryFee;
    @JsonProperty("DeliveryFeeText")
    private String deliveryFeeText;
    @JsonProperty("DeliveryInterval")
    private Integer deliveryInterval;
    @JsonProperty("LogoUrl")
    private String logoUrl;
    @JsonProperty("BrandImageUrl")
    private String brandImageUrl;
    @JsonProperty("BackgroundUrl")
    private String backgroundUrl;
    @JsonProperty("CategoryName")
    private String categoryName;
    @JsonProperty("AcceptsFutureOrder")
    private Boolean acceptsFutureOrder;
    @JsonProperty("IsTipAvailable")
    private Boolean isTipAvailable;
    @JsonProperty("DeliveryTypeId")
    private Integer deliveryTypeId;
    @JsonProperty("DeliveryType")
    private String deliveryType;
    @JsonProperty("IsOpen")
    private Boolean isOpen;
    @JsonProperty("Categories")
    private List<Category> categories = null;
    @JsonProperty("DeliveryTypes")
    private List<DeliveryType> deliveryTypes = null;
    @JsonProperty("PaymentTypes")
    private List<String> paymentTypes = null;
    @JsonProperty("WorkingHours")
    private List<WorkingHour> workingHours = null;

    @JsonProperty("Id")
    public String getId() {
        return id;
    }

    @JsonProperty("Id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("Name")
    public String getName() {
        return name;
    }

    @JsonProperty("Name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("City")
    public String getCity() {
        return city;
    }

    @JsonProperty("City")
    public void setCity(String city) {
        this.city = city;
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

    @JsonProperty("DeliveryTime")
    public String getDeliveryTime() {
        return deliveryTime;
    }

    @JsonProperty("DeliveryTime")
    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    @JsonProperty("MinBasketAmount")
    public Integer getMinBasketAmount() {
        return minBasketAmount;
    }

    @JsonProperty("MinBasketAmount")
    public void setMinBasketAmount(Integer minBasketAmount) {
        this.minBasketAmount = minBasketAmount;
    }

    @JsonProperty("MinBasketAmountText")
    public String getMinBasketAmountText() {
        return minBasketAmountText;
    }

    @JsonProperty("MinBasketAmountText")
    public void setMinBasketAmountText(String minBasketAmountText) {
        this.minBasketAmountText = minBasketAmountText;
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

    @JsonProperty("DeliveryFeeText")
    public String getDeliveryFeeText() {
        return deliveryFeeText;
    }

    @JsonProperty("DeliveryFeeText")
    public void setDeliveryFeeText(String deliveryFeeText) {
        this.deliveryFeeText = deliveryFeeText;
    }

    @JsonProperty("DeliveryInterval")
    public Integer getDeliveryInterval() {
        return deliveryInterval;
    }

    @JsonProperty("DeliveryInterval")
    public void setDeliveryInterval(Integer deliveryInterval) {
        this.deliveryInterval = deliveryInterval;
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

    @JsonProperty("BackgroundUrl")
    public String getBackgroundUrl() {
        return backgroundUrl;
    }

    @JsonProperty("BackgroundUrl")
    public void setBackgroundUrl(String backgroundUrl) {
        this.backgroundUrl = backgroundUrl;
    }

    @JsonProperty("CategoryName")
    public String getCategoryName() {
        return categoryName;
    }

    @JsonProperty("CategoryName")
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
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

    @JsonProperty("DeliveryTypeId")
    public Integer getDeliveryTypeId() {
        return deliveryTypeId;
    }

    @JsonProperty("DeliveryTypeId")
    public void setDeliveryTypeId(Integer deliveryTypeId) {
        this.deliveryTypeId = deliveryTypeId;
    }

    @JsonProperty("DeliveryType")
    public String getDeliveryType() {
        return deliveryType;
    }

    @JsonProperty("DeliveryType")
    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    @JsonProperty("IsOpen")
    public Boolean getIsOpen() {
        return isOpen;
    }

    @JsonProperty("IsOpen")
    public void setIsOpen(Boolean isOpen) {
        this.isOpen = isOpen;
    }

    @JsonProperty("Categories")
    public List<Category> getCategories() {
        return categories;
    }

    @JsonProperty("Categories")
    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    @JsonProperty("DeliveryTypes")
    public List<DeliveryType> getDeliveryTypes() {
        return deliveryTypes;
    }

    @JsonProperty("DeliveryTypes")
    public void setDeliveryTypes(List<DeliveryType> deliveryTypes) {
        this.deliveryTypes = deliveryTypes;
    }

    @JsonProperty("PaymentTypes")
    public List<String> getPaymentTypes() {
        return paymentTypes;
    }

    @JsonProperty("PaymentTypes")
    public void setPaymentTypes(List<String> paymentTypes) {
        this.paymentTypes = paymentTypes;
    }

    @JsonProperty("WorkingHours")
    public List<WorkingHour> getWorkingHours() {
        return workingHours;
    }

    @JsonProperty("WorkingHours")
    public void setWorkingHours(List<WorkingHour> workingHours) {
        this.workingHours = workingHours;
    }

}

package apiEngine.models.response.Basket.Campaign;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Id",
        "Code",
        "Name",
        "ImageUrl",
        "IsOtpRequired",
        "IsSelected"
})
@Generated("jsonschema2pojo")
public class Coupon {

    @JsonProperty("Id")
    private String id;
    @JsonProperty("Code")
    private String code;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("ImageUrl")
    private String imageUrl;
    @JsonProperty("IsOtpRequired")
    private Boolean isOtpRequired;
    @JsonProperty("IsSelected")
    private Boolean isSelected;

    /**
     * No args constructor for use in serialization
     *
     */
    public Coupon() {
    }

    /**
     *
     * @param isOtpRequired
     * @param code
     * @param imageUrl
     * @param name
     * @param isSelected
     * @param id
     */
    public Coupon(String id, String code, String name, String imageUrl, Boolean isOtpRequired, Boolean isSelected) {
        super();
        this.id = id;
        this.code = code;
        this.name = name;
        this.imageUrl = imageUrl;
        this.isOtpRequired = isOtpRequired;
        this.isSelected = isSelected;
    }

    @JsonProperty("Id")
    public String getId() {
        return id;
    }

    @JsonProperty("Id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("Code")
    public String getCode() {
        return code;
    }

    @JsonProperty("Code")
    public void setCode(String code) {
        this.code = code;
    }

    @JsonProperty("Name")
    public String getName() {
        return name;
    }

    @JsonProperty("Name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("ImageUrl")
    public String getImageUrl() {
        return imageUrl;
    }

    @JsonProperty("ImageUrl")
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @JsonProperty("IsOtpRequired")
    public Boolean getIsOtpRequired() {
        return isOtpRequired;
    }

    @JsonProperty("IsOtpRequired")
    public void setIsOtpRequired(Boolean isOtpRequired) {
        this.isOtpRequired = isOtpRequired;
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
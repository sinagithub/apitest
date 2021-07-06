package apiEngine.models.requests.InternalVendor.Marketing;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "CreateCoupon",
        "PrefixSuffix",
        "ConstantCode",
        "CouponCount",
        "UsageLimit",
        "CouponCode"
})

public class Coupon {

    @JsonProperty("CreateCoupon")
    private Boolean createCoupon;
    @JsonProperty("PrefixSuffix")
    private Integer prefixSuffix;
    @JsonProperty("ConstantCode")
    private String constantCode;
    @JsonProperty("CouponCount")
    private Integer couponCount;
    @JsonProperty("UsageLimit")
    private Integer usageLimit;
    @JsonProperty("CouponCode")
    private String couponCode;

    /**
     * No args constructor for use in serialization
     *
     */
    public Coupon() {
    }

    /**
     *
     * @param prefixSuffix
     * @param constantCode
     * @param createCoupon
     * @param usageLimit
     * @param couponCount
     * @param couponCode
     */
    public Coupon(Boolean createCoupon, Integer prefixSuffix, String constantCode, Integer couponCount, Integer usageLimit, String couponCode) {
        super();
        this.createCoupon = createCoupon;
        this.prefixSuffix = prefixSuffix;
        this.constantCode = constantCode;
        this.couponCount = couponCount;
        this.usageLimit = usageLimit;
        this.couponCode = couponCode;
    }

    @JsonProperty("CreateCoupon")
    public Boolean getCreateCoupon() {
        return createCoupon;
    }

    @JsonProperty("CreateCoupon")
    public void setCreateCoupon(Boolean createCoupon) {
        this.createCoupon = createCoupon;
    }

    @JsonProperty("PrefixSuffix")
    public Integer getPrefixSuffix() {
        return prefixSuffix;
    }

    @JsonProperty("PrefixSuffix")
    public void setPrefixSuffix(Integer prefixSuffix) {
        this.prefixSuffix = prefixSuffix;
    }

    @JsonProperty("ConstantCode")
    public String getConstantCode() {
        return constantCode;
    }

    @JsonProperty("ConstantCode")
    public void setConstantCode(String constantCode) {
        this.constantCode = constantCode;
    }

    @JsonProperty("CouponCount")
    public Integer getCouponCount() {
        return couponCount;
    }

    @JsonProperty("CouponCount")
    public void setCouponCount(Integer couponCount) {
        this.couponCount = couponCount;
    }

    @JsonProperty("UsageLimit")
    public Integer getUsageLimit() {
        return usageLimit;
    }

    @JsonProperty("UsageLimit")
    public void setUsageLimit(Integer usageLimit) {
        this.usageLimit = usageLimit;
    }

    @JsonProperty("CouponCode")
    public String getCouponCode() {
        return couponCode;
    }

    @JsonProperty("CouponCode")
    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

}

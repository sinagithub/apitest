package apiEngine.models.requests.Checkout;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "HasDonation",
        "DonationType",
        "DonationAmount",
        "DonationFoundationId",
        "HasTip",
        "TipType",
        "TipAmount"
})

public class TipAndDonationInfo {

    @JsonProperty("HasDonation")
    private Boolean hasDonation;
    @JsonProperty("DonationType")
    private Integer donationType;
    @JsonProperty("DonationAmount")
    private Integer donationAmount;
    @JsonProperty("DonationFoundationId")
    private String donationFoundationId;
    @JsonProperty("HasTip")
    private Boolean hasTip;
    @JsonProperty("TipType")
    private Integer tipType;
    @JsonProperty("TipAmount")
    private Integer tipAmount;

    /**
     * No args constructor for use in serialization
     *
     */
    public TipAndDonationInfo() {
    }

    /**
     *
     * @param tipType
     * @param hasTip
     * @param tipAmount
     * @param donationFoundationId
     * @param hasDonation
     * @param donationType
     * @param donationAmount
     */
    public TipAndDonationInfo(Boolean hasDonation, Integer donationType, Integer donationAmount, String donationFoundationId, Boolean hasTip, Integer tipType, Integer tipAmount) {
        super();
        this.hasDonation = hasDonation;
        this.donationType = donationType;
        this.donationAmount = donationAmount;
        this.donationFoundationId = donationFoundationId;
        this.hasTip = hasTip;
        this.tipType = tipType;
        this.tipAmount = tipAmount;
    }

    @JsonProperty("HasDonation")
    public Boolean getHasDonation() {
        return hasDonation;
    }

    @JsonProperty("HasDonation")
    public void setHasDonation(Boolean hasDonation) {
        this.hasDonation = hasDonation;
    }

    @JsonProperty("DonationType")
    public Integer getDonationType() {
        return donationType;
    }

    @JsonProperty("DonationType")
    public void setDonationType(Integer donationType) {
        this.donationType = donationType;
    }

    @JsonProperty("DonationAmount")
    public Integer getDonationAmount() {
        return donationAmount;
    }

    @JsonProperty("DonationAmount")
    public void setDonationAmount(Integer donationAmount) {
        this.donationAmount = donationAmount;
    }

    @JsonProperty("DonationFoundationId")
    public String getDonationFoundationId() {
        return donationFoundationId;
    }

    @JsonProperty("DonationFoundationId")
    public void setDonationFoundationId(String donationFoundationId) {
        this.donationFoundationId = donationFoundationId;
    }

    @JsonProperty("HasTip")
    public Boolean getHasTip() {
        return hasTip;
    }

    @JsonProperty("HasTip")
    public void setHasTip(Boolean hasTip) {
        this.hasTip = hasTip;
    }

    @JsonProperty("TipType")
    public Integer getTipType() {
        return tipType;
    }

    @JsonProperty("TipType")
    public void setTipType(Integer tipType) {
        this.tipType = tipType;
    }

    @JsonProperty("TipAmount")
    public Integer getTipAmount() {
        return tipAmount;
    }

    @JsonProperty("TipAmount")
    public void setTipAmount(Integer tipAmount) {
        this.tipAmount = tipAmount;
    }

}

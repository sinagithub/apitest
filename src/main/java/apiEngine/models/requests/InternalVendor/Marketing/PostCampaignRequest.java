package apiEngine.models.requests.InternalVendor.Marketing;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Campaign",
        "DescriptionTr",
        "DescriptionEn",
        "Award",
        "Conditions",
        "Targets",
        "Coupon",
        "StateInfo"
})

public class PostCampaignRequest {

    @JsonProperty("Campaign")
    private Campaign campaign;
    @JsonProperty("DescriptionTr")
    private DescriptionTr descriptionTr;
    @JsonProperty("DescriptionEn")
    private DescriptionEn descriptionEn;
    @JsonProperty("Award")
    private Award award;
    @JsonProperty("Conditions")
    private List<Condition> conditions = null;
    @JsonProperty("Targets")
    private List<Target> targets = null;
    @JsonProperty("Coupon")
    private Coupon coupon;
    @JsonProperty("StateInfo")
    private String stateInfo;

    /**
     * No args constructor for use in serialization
     *
     */
    public PostCampaignRequest() {
    }

    /**
     *
     * @param descriptionEn
     * @param award
     * @param coupon
     * @param campaign
     * @param stateInfo
     * @param conditions
     * @param targets
     * @param descriptionTr
     */
    public PostCampaignRequest(Campaign campaign, DescriptionTr descriptionTr, DescriptionEn descriptionEn, Award award, List<Condition> conditions, List<Target> targets, Coupon coupon, String stateInfo) {
        super();
        this.campaign = campaign;
        this.descriptionTr = descriptionTr;
        this.descriptionEn = descriptionEn;
        this.award = award;
        this.conditions = conditions;
        this.targets = targets;
        this.coupon = coupon;
        this.stateInfo = stateInfo;
    }

    @JsonProperty("Campaign")
    public Campaign getCampaign() {
        return campaign;
    }

    @JsonProperty("Campaign")
    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }

    @JsonProperty("DescriptionTr")
    public DescriptionTr getDescriptionTr() {
        return descriptionTr;
    }

    @JsonProperty("DescriptionTr")
    public void setDescriptionTr(DescriptionTr descriptionTr) {
        this.descriptionTr = descriptionTr;
    }

    @JsonProperty("DescriptionEn")
    public DescriptionEn getDescriptionEn() {
        return descriptionEn;
    }

    @JsonProperty("DescriptionEn")
    public void setDescriptionEn(DescriptionEn descriptionEn) {
        this.descriptionEn = descriptionEn;
    }

    @JsonProperty("Award")
    public Award getAward() {
        return award;
    }

    @JsonProperty("Award")
    public void setAward(Award award) {
        this.award = award;
    }

    @JsonProperty("Conditions")
    public List<Condition> getConditions() {
        return conditions;
    }

    @JsonProperty("Conditions")
    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    @JsonProperty("Targets")
    public List<Target> getTargets() {
        return targets;
    }

    @JsonProperty("Targets")
    public void setTargets(List<Target> targets) {
        this.targets = targets;
    }

    @JsonProperty("Coupon")
    public Coupon getCoupon() {
        return coupon;
    }

    @JsonProperty("Coupon")
    public void setCoupon(Coupon coupon) {
        this.coupon = coupon;
    }

    @JsonProperty("StateInfo")
    public String getStateInfo() {
        return stateInfo;
    }

    @JsonProperty("StateInfo")
    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

}
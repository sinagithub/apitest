package apiEngine.models.requests.YsUserService;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "ApiKey",
        "DefaultAreaId",
        "Email",
        "EmailCommunication",
        "FirstName",
        "LastName",
        "Password",
        "RepeatPassword",
        "SmsPromotion"
})

public class UserData {

    @JsonProperty("ApiKey")
    private String apiKey;
    @JsonProperty("DefaultAreaId")
    private String defaultAreaId;
    @JsonProperty("Email")
    private String email;
    @JsonProperty("EmailCommunication")
    private String emailCommunication;
    @JsonProperty("FirstName")
    private String firstName;
    @JsonProperty("LastName")
    private String lastName;
    @JsonProperty("Password")
    private String password;
    @JsonProperty("RepeatPassword")
    private String repeatPassword;
    @JsonProperty("SmsPromotion")
    private String smsPromotion;

    /**
     * No args constructor for use in serialization
     *
     */
    public UserData() {
    }

    /**
     *
     * @param smsPromotion
     * @param firstName
     * @param lastName
     * @param password
     * @param apiKey
     * @param repeatPassword
     * @param defaultAreaId
     * @param emailCommunication
     * @param email
     */
    public UserData(String apiKey, String defaultAreaId, String email, String emailCommunication, String firstName, String lastName, String password, String repeatPassword, String smsPromotion) {
        super();
        this.apiKey = apiKey;
        this.defaultAreaId = defaultAreaId;
        this.email = email;
        this.emailCommunication = emailCommunication;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.repeatPassword = repeatPassword;
        this.smsPromotion = smsPromotion;
    }

    @JsonProperty("ApiKey")
    public String getApiKey() {
        return apiKey;
    }

    @JsonProperty("ApiKey")
    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    @JsonProperty("DefaultAreaId")
    public String getDefaultAreaId() {
        return defaultAreaId;
    }

    @JsonProperty("DefaultAreaId")
    public void setDefaultAreaId(String defaultAreaId) {
        this.defaultAreaId = defaultAreaId;
    }

    @JsonProperty("Email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("Email")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("EmailCommunication")
    public String getEmailCommunication() {
        return emailCommunication;
    }

    @JsonProperty("EmailCommunication")
    public void setEmailCommunication(String emailCommunication) {
        this.emailCommunication = emailCommunication;
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

    @JsonProperty("Password")
    public String getPassword() {
        return password;
    }

    @JsonProperty("Password")
    public void setPassword(String password) {
        this.password = password;
    }

    @JsonProperty("RepeatPassword")
    public String getRepeatPassword() {
        return repeatPassword;
    }

    @JsonProperty("RepeatPassword")
    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

    @JsonProperty("SmsPromotion")
    public String getSmsPromotion() {
        return smsPromotion;
    }

    @JsonProperty("SmsPromotion")
    public void setSmsPromotion(String smsPromotion) {
        this.smsPromotion = smsPromotion;
    }

}

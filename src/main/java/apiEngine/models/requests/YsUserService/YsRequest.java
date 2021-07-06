package apiEngine.models.requests.YsUserService;



import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
        "PageNumber",
        "PageRowCount",
        "ApiKey",
        "CatalogName",
        "Token"
})

public class YsRequest {

    @JsonProperty("PageNumber")
    private String pageNumber;
    @JsonProperty("PageRowCount")
    private String pageRowCount;
    @JsonProperty("ApiKey")
    private String apiKey;
    @JsonProperty("CatalogName")
    private String catalogName;
    @JsonProperty("Token")
    private String token;

    /**
     * No args constructor for use in serialization
     */
    public YsRequest() {
    }

    /**
     * @param catalogName
     * @param pageRowCount
     * @param pageNumber
     * @param apiKey
     * @param token
     */
    public YsRequest(String pageNumber, String pageRowCount, String apiKey, String catalogName, String token) {
        super();
        this.pageNumber = pageNumber;
        this.pageRowCount = pageRowCount;
        this.apiKey = apiKey;
        this.catalogName = catalogName;
        this.token = token;
    }

    @JsonProperty("PageNumber")
    public String getPageNumber() {
        return pageNumber;
    }

    @JsonProperty("PageNumber")
    public void setPageNumber(String pageNumber) {
        this.pageNumber = pageNumber;
    }

    @JsonProperty("PageRowCount")
    public String getPageRowCount() {
        return pageRowCount;
    }

    @JsonProperty("PageRowCount")
    public void setPageRowCount(String pageRowCount) {
        this.pageRowCount = pageRowCount;
    }

    @JsonProperty("ApiKey")
    public String getApiKey() {
        return apiKey;
    }

    @JsonProperty("ApiKey")
    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    @JsonProperty("CatalogName")
    public String getCatalogName() {
        return catalogName;
    }

    @JsonProperty("CatalogName")
    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    @JsonProperty("Token")
    public String getToken() {
        return token;
    }

    @JsonProperty("Token")
    public void setToken(String token) {
        this.token = token;
    }

}

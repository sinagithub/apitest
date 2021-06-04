package apiEngine.models.response.Basket.Refresh;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Id",
        "Content",
        "Title",
        "AgreementType"
})
@Generated("jsonschema2pojo")
public class Datum {

    @JsonProperty("Id")
    private String id;
    @JsonProperty("Content")
    private String content;
    @JsonProperty("Title")
    private String title;
    @JsonProperty("AgreementType")
    private String agreementType;

    @JsonProperty("Id")
    public String getId() {
        return id;
    }

    @JsonProperty("Id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("Content")
    public String getContent() {
        return content;
    }

    @JsonProperty("Content")
    public void setContent(String content) {
        this.content = content;
    }

    @JsonProperty("Title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("Title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("AgreementType")
    public String getAgreementType() {
        return agreementType;
    }

    @JsonProperty("AgreementType")
    public void setAgreementType(String agreementType) {
        this.agreementType = agreementType;
    }

}
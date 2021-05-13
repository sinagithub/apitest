package apiEngine.models.response.Content;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Id",
        "Header",
        "Text",
        "IsActive"
})
@Generated("jsonschema2pojo")
public class FaqData {

    @JsonProperty("Id")
    private Integer id;
    @JsonProperty("Header")
    private String header;
    @JsonProperty("Text")
    private String text;
    @JsonProperty("IsActive")
    private Boolean isActive;

    @JsonProperty("Id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("Id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("Header")
    public String getHeader() {
        return header;
    }

    @JsonProperty("Header")
    public void setHeader(String header) {
        this.header = header;
    }

    @JsonProperty("Text")
    public String getText() {
        return text;
    }

    @JsonProperty("Text")
    public void setText(String text) {
        this.text = text;
    }

    @JsonProperty("IsActive")
    public Boolean getIsActive() {
        return isActive;
    }

    @JsonProperty("IsActive")
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

}
package apiEngine.models.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonPropertyOrder({
        "Data",
        "Version",
        "Info"
})
public class AddressResponse {

    @JsonProperty("Data")
    private List<Address> data = null;
    @JsonProperty("Version")
    private String version;
    @JsonProperty("Info")
    private BanabiInfo banabiInfo;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Data")
    public List<Address> getData() {
        return data;
    }

    @JsonProperty("Data")
    public void setData(List<Address> data) {
        this.data = data;
    }

    @JsonProperty("Version")
    public String getVersion() {
        return version;
    }

    @JsonProperty("Version")
    public void setVersion(String version) {
        this.version = version;
    }

    @JsonProperty("Info")
    public BanabiInfo getInfo() {
        return banabiInfo;
    }

    @JsonProperty("Info")
    public void setInfo(BanabiInfo banabiInfo) {
        this.banabiInfo = banabiInfo;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

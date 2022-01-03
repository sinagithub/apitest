package apiEngine.models.response.Address;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Data",
        "InfoList"
})

public class AddressActionResponse {

        @JsonProperty("Data")
        private AddressActionData data;
        @JsonProperty("InfoList")
        private List<Object> infoList = null;

        @JsonProperty("Data")
        public AddressActionData getData() {
            return data;
        }

        @JsonProperty("Data")
        public void setData(AddressActionData data) {
            this.data = data;
        }

        @JsonProperty("InfoList")
        public List<Object> getInfoList() {
            return infoList;
        }

        @JsonProperty("InfoList")
        public void setInfoList(List<Object> infoList) {
            this.infoList = infoList;
        }
}

package apiEngine.models.response.Address;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "ActionType",
        "AddressInfo"
})
public class AddressActionData {

        @JsonProperty("ActionType")
        private Integer actionType;
        @JsonProperty("Address")
        private AddressActionDetail address;

        @JsonProperty("ActionType")
        public Integer getActionType() {
            return actionType;
        }

        @JsonProperty("ActionType")
        public void setActionType(Integer actionType) {
            this.actionType = actionType;
        }

    @JsonProperty("Address")
    public AddressActionDetail getAddress() {
        return address;
    }

        @JsonProperty("Address")
        public void setAddress(AddressActionDetail address) {
            this.address = address;
        }

    }

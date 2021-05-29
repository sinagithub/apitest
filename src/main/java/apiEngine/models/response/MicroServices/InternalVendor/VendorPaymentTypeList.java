package apiEngine.models.response.MicroServices.InternalVendor;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class VendorPaymentTypeList {
    private List<String> paymentTypes = null;

    public List<String> getPaymentTypes() {
        return paymentTypes;
    }

    @JsonProperty("IsOpen")
    public void setPaymentTypes(List<String> paymentTypes) {
        this.paymentTypes = paymentTypes;
    }
}

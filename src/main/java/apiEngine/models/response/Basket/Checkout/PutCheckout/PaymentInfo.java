package apiEngine.models.response.Basket.Checkout.PutCheckout;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "MethodId",
        "TypeId",
        "BinNumber"
})

public class PaymentInfo {

    @JsonProperty("MethodId")
    private String methodId;
    @JsonProperty("TypeId")
    private String typeId;
    @JsonProperty("BinNumber")
    private Integer binNumber;

    @JsonProperty("MethodId")
    public String getMethodId() {
        return methodId;
    }

    @JsonProperty("MethodId")
    public void setMethodId(String methodId) {
        this.methodId = methodId;
    }

    @JsonProperty("TypeId")
    public String getTypeId() {
        return typeId;
    }

    @JsonProperty("TypeId")
    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    @JsonProperty("BinNumber")
    public Integer getBinNumber() {
        return binNumber;
    }

    @JsonProperty("BinNumber")
    public void setBinNumber(Integer binNumber) {
        this.binNumber = binNumber;
    }

}

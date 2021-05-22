package apiEngine.models.response.Basket.Checkout;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
        "Id",
        "Title",
        "IconUrl",
        "PaymentMethods"
})

public class PaymentType {

    @JsonProperty("Id")
    private String id;
    @JsonProperty("Title")
    private String title;
    @JsonProperty("IconUrl")
    private String iconUrl;
    @JsonProperty("PaymentMethods")
    private List<PaymentMethod> paymentMethods = null;

    @JsonProperty("Id")
    public String getId() {
        return id;
    }

    @JsonProperty("Id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("Title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("Title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("IconUrl")
    public String getIconUrl() {
        return iconUrl;
    }

    @JsonProperty("IconUrl")
    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    @JsonProperty("PaymentMethods")
    public List<PaymentMethod> getPaymentMethods() {
        return paymentMethods;
    }

    @JsonProperty("PaymentMethods")
    public void setPaymentMethods(List<PaymentMethod> paymentMethods) {
        this.paymentMethods = paymentMethods;
    }

}

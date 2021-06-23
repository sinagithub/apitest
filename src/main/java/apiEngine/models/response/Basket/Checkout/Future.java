package apiEngine.models.response.Basket.Checkout;

import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Id",
        "Title",
        "Description",
        "Days",
        "IsSelected"
})
@Generated("jsonschema2pojo")
public class Future {

    @JsonProperty("Id")
    private String id;
    @JsonProperty("Title")
    private String title;
    @JsonProperty("Description")
    private String description;
    @JsonProperty("Days")
    private List<Day> days = null;
    @JsonProperty("IsSelected")
    private Boolean isSelected;

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

    @JsonProperty("Description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("Description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("Days")
    public List<Day> getDays() {
        return days;
    }

    @JsonProperty("Days")
    public void setDays(List<Day> days) {
        this.days = days;
    }
    @JsonProperty("IsSelected")
    public Boolean getSelected() {
        return isSelected;
    }
    @JsonProperty("IsSelected")
    public void setSelected(Boolean selected) {
        isSelected = selected;
    }
}

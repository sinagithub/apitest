package apiEngine.models.requests.Order;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Note"
})
@Generated("jsonschema2pojo")
public class WriteOrderNoteRequest {

    @JsonProperty("Note")
    private String note;

    /**
     * No args constructor for use in serialization
     *
     */
    public WriteOrderNoteRequest() {
    }

    /**
     *
     * @param note
     */
    public WriteOrderNoteRequest(String note) {
        super();
        this.note = note;
    }

    @JsonProperty("Note")
    public String getNote() {
        return note;
    }

    @JsonProperty("Note")
    public void setNote(String note) {
        this.note = note;
    }

}

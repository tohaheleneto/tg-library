package bot.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Updates {
    public final boolean ok;
    public final List<Update> result;
    public final String description;

    @JsonCreator
    public Updates(@JsonProperty("ok") boolean ok,
                   @JsonProperty("result") List<Update> result,
                   @JsonProperty("description") String description) {
        this.ok = ok;
        this.result = result;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Updates{" +
                "ok=" + ok +
                ", result=" + result +
                ", description='" + description + '\'' +
                '}';
    }
}

package bot.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DocumentResponse {
    private final boolean ok;
    private final Document result;
    private final String errorCode;
    private final String description;

    @JsonCreator
    public DocumentResponse(
            @JsonProperty("ok") boolean ok,
            @JsonProperty("result") Document result,
            @JsonProperty("error_code") String errorCode,
            @JsonProperty("description") String description
    ) {
        this.ok = ok;
        this.result = result;
        this.errorCode = errorCode;
        this.description = description;
    }

    public boolean isOk() {
        return ok;
    }

    public Document getResult() {
        return result;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "DocumentRequestResult{" +
                "ok=" + ok +
                ", result=" + result +
                '}';
    }
}

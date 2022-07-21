package bot.models;

import java.util.List;

public class UpdatesRequest {
    public final Integer offset;
    public final Integer limit;
    public final Integer timeout;
    public final List<String> allowedUpdates;


    private UpdatesRequest(Builder builder) {
        this.offset = builder.offset;
        this.limit = builder.limit;
        this.timeout = builder.timeout;
        this.allowedUpdates = builder.allowedUpdates;
    }

    public UpdatesRequest(Integer offset, Integer limit, Integer timeout, List<String> allowedUpdates) {
        this.offset = offset;
        this.limit = limit;
        this.timeout = timeout;
        this.allowedUpdates = allowedUpdates;
    }


    public static final class Builder {
        private Integer offset;
        private Integer limit;
        private Integer timeout;
        private List<String> allowedUpdates;

        private Builder() {
        }

        public static Builder updatesRequest() {
            return new Builder();
        }

        public Builder offset(Integer offset) {
            this.offset = offset;
            return this;
        }

        public Builder limit(Integer limit) {
            this.limit = limit;
            return this;
        }

        public Builder timeout(Integer timeout) {
            this.timeout = timeout;
            return this;
        }

        public Builder allowedUpdates(List<String> allowedUpdates) {
            this.allowedUpdates = allowedUpdates;
            return this;
        }

        public UpdatesRequest build() {
            return new UpdatesRequest(this);
        }
    }
}

package bot.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageEntity {
    Integer offset;
    Integer length;
    String type;

    public MessageEntity(@JsonProperty("offset") Integer offset,
                         @JsonProperty("length") Integer length,
                         @JsonProperty("type") String type) {
        this.offset = offset;
        this.length = length;
        this.type = type;
    }

    private MessageEntity(Builder builder) {
        this.offset = builder.offset;
        this.length = builder.length;
        this.type = builder.type;
    }

    @Override
    public String toString() {
        return "Entities{" +
                "offset=" + offset +
                ", length=" + length +
                ", type='" + type + '\'' +
                '}';
    }

    public static final class Builder {
        private Integer offset;
        private Integer length;
        private String type;

        private Builder() {
        }

        public static Builder messageEntity() {
            return new Builder();
        }

        public Builder offset(Integer offset) {
            this.offset = offset;
            return this;
        }

        public Builder length(Integer length) {
            this.length = length;
            return this;
        }

        public Builder type(String type) {
            this.type = type;
            return this;
        }

        public MessageEntity build() {
            return new MessageEntity(this);
        }
    }
}

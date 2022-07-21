package bot.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * <a href="https://core.telegram.org/bots/api#update">tg object doc</a>
 */
public class Update {
    public final int updateId;
    Message message;
    Message editedMessage;
    Message channelPost;
    Message editedChannelPost;

    public Update(@JsonProperty("update_id") int updateId,
                  @JsonProperty("message") Message message,
                  @JsonProperty("edited_message") Message editedMessage,
                  @JsonProperty("channel_post") Message channelPost,
                  @JsonProperty("edited_channel_post") Message editedChannelPost) {
        this.updateId = updateId;
        this.message = message;
        this.editedMessage = editedMessage;
        this.channelPost = channelPost;
        this.editedChannelPost = editedChannelPost;
    }

    private Update(Builder builder) {
        this.updateId = builder.updateId;
        this.message = builder.message;
        this.editedMessage = builder.editedMessage;
        this.channelPost = builder.channelPost;
        this.editedChannelPost = builder.editedChannelPost;
    }

    //TODO fill later


    public static final class Builder {
        private int updateId;
        private Message message;
        private Message editedMessage;
        private Message channelPost;
        private Message editedChannelPost;

        private Builder() {
        }

        public static Builder update() {
            return new Builder();
        }

        public Builder updateId(int updateId) {
            this.updateId = updateId;
            return this;
        }

        public Builder message(Message message) {
            this.message = message;
            return this;
        }

        public Builder editedMessage(Message editedMessage) {
            this.editedMessage = editedMessage;
            return this;
        }

        public Builder channelPost(Message channelPost) {
            this.channelPost = channelPost;
            return this;
        }

        public Builder editedChannelPost(Message editedChannelPost) {
            this.editedChannelPost = editedChannelPost;
            return this;
        }

        public Update build() {
            return new Update(this);
        }
    }
}

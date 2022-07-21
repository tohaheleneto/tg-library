package bot.models.to;


import bot.models.MessageEntity;
import bot.models.keyboard.ReplyKeyboard;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * https://core.telegram.org/bots/api#sendmessage
 */
public class SendMessage {
    public final String chatId;
    public final String text;

    public final String parseMode;

    public final List<MessageEntity> entities;
    public final ReplyKeyboard replyKeyboardMarkup;


    public SendMessage(@JsonProperty("chat_id") String chatId,
                       @JsonProperty("text") String text,
                       @JsonProperty("parse_mode") String parseMode,
                       @JsonProperty("entities") List<MessageEntity> entities,
                       @JsonProperty("replyKeyboardMarkup") ReplyKeyboard replyKeyboardMarkup) {
        this.chatId = chatId;
        this.text = text;
        this.parseMode = parseMode;
        this.entities = entities;
        this.replyKeyboardMarkup = replyKeyboardMarkup;
    }

    private SendMessage(Builder builder) {
        this.chatId = builder.chatId;
        this.text = builder.text;
        this.parseMode = builder.parseMode;
        this.entities = builder.entities;
        this.replyKeyboardMarkup = builder.replyKeyboardMarkup;
    }


    @Override
    public String toString() {
        return "SendMessage{" +
                "chatId='" + chatId + '\'' +
                ", text='" + text + '\'' +
                ", entities=" + entities +
                '}';
    }

    public static final class Builder {
        private String chatId;
        private String text;
        private String parseMode;
        private List<MessageEntity> entities;
        private ReplyKeyboard replyKeyboardMarkup;

        private Builder() {
        }

        public static Builder sendMessage() {
            return new Builder();
        }

        public Builder chatId(String chatId) {
            this.chatId = chatId;
            return this;
        }

        public Builder text(String text) {
            this.text = text;
            return this;
        }

        public Builder parseMode(String parseMode) {
            this.parseMode = parseMode;
            return this;
        }

        public Builder entities(List<MessageEntity> entities) {
            this.entities = entities;
            return this;
        }

        public Builder replyKeyboardMarkup(ReplyKeyboard replyKeyboardMarkup) {
            this.replyKeyboardMarkup = replyKeyboardMarkup;
            return this;
        }

        public SendMessage build() {
            return new SendMessage(this);
        }
    }
}

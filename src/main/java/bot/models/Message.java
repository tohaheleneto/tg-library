package bot.models;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

// https://core.telegram.org/bots/api#message
//TODO fix
public class Message {
    int messageId;
    User from;
    Chat senderChat;

    Chat chat;
    long date; //TODO maybe convert to localTime ?

    User forwardFrom;

    Chat forwardFromChat;

//    Integer forward_from_message_id;

//    String forward_signature;

//    String forward_sender_name;

//    Integer forward_date;

//    Boolean is_automatic_forward;

//    Message reply_to_message;

//    User via_bot;

//    Integer edit_date;

    String text;
    Document document;

    @JsonProperty("entities")
    List<MessageEntity> entities;

    public Message(@JsonProperty("message_id") int messageId,
                   @JsonProperty("from") User from,
                   @JsonProperty("sender_chat") Chat senderChat,
                   @JsonProperty("chat") Chat chat,
                   @JsonProperty("date") long date,
                   @JsonProperty("forward_from") User forwardFrom,
                   @JsonProperty("forward_from_chat") Chat forwardFromChat,
                   @JsonProperty("text") String text,
                   @JsonProperty("document") Document document,
                   @JsonProperty("entities") List<MessageEntity> entities) {
        this.messageId = messageId;
        this.from = from;
        this.senderChat = senderChat;
        this.chat = chat;
        this.date = date;
        this.forwardFrom = forwardFrom;
        this.forwardFromChat = forwardFromChat;
        this.text = text;
        this.document = document;
        this.entities = entities;
    }

    private Message(Builder builder) {
        this.messageId = builder.messageId;
        this.from = builder.from;
        this.senderChat = builder.senderChat;
        this.chat = builder.chat;
        this.date = builder.date;
        this.forwardFrom = builder.forwardFrom;
        this.forwardFromChat = builder.forwardFromChat;
        this.text = builder.text;
        this.document = builder.document;
        this.entities = builder.entities;
    }

    @Override
    public String toString() {
        return "Message{" +
                "message_id=" + messageId +
                ", from=" + from +
                ", chat=" + chat +
                ", date=" + date +
                ", text='" + text + '\'' +
                ", document=" + document +
                ", entities=" + entities +
                '}';
    }

    public static final class Builder {
        private int messageId;
        private User from;
        private Chat senderChat;
        private Chat chat;
        private long date;
        private User forwardFrom;
        private Chat forwardFromChat;
        private String text;
        private Document document;
        private List<MessageEntity> entities;

        private Builder() {
        }

        public static Builder message() {
            return new Builder();
        }

        public Builder messageId(int messageId) {
            this.messageId = messageId;
            return this;
        }

        public Builder from(User from) {
            this.from = from;
            return this;
        }

        public Builder senderChat(Chat senderChat) {
            this.senderChat = senderChat;
            return this;
        }

        public Builder chat(Chat chat) {
            this.chat = chat;
            return this;
        }

        public Builder date(long date) {
            this.date = date;
            return this;
        }

        public Builder forwardFrom(User forwardFrom) {
            this.forwardFrom = forwardFrom;
            return this;
        }

        public Builder forwardFromChat(Chat forwardFromChat) {
            this.forwardFromChat = forwardFromChat;
            return this;
        }

        public Builder text(String text) {
            this.text = text;
            return this;
        }

        public Builder document(Document document) {
            this.document = document;
            return this;
        }

        public Builder entities(List<MessageEntity> entities) {
            this.entities = entities;
            return this;
        }

        public Message build() {
            return new Message(this);
        }
    }
}

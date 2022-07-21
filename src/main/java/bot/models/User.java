package bot.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    private String id;
    private boolean isBot;
    private String firstName;
    private String lastName;
    private String username;
    private String languageCode;

    public User(@JsonProperty String id,
                @JsonProperty("is_bot") boolean isBot,
                @JsonProperty("first_name") String firstName,
                @JsonProperty("last_name") String lastName, String username,
                @JsonProperty("language_code") String languageCode) {
        this.id = id;
        this.isBot = isBot;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.languageCode = languageCode;
    }

    private User(Builder builder) {
        this.id = builder.id;
        this.isBot = builder.isBot;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.username = builder.username;
        this.languageCode = builder.languageCode;
    }


    public static final class Builder {
        private String id;
        private boolean isBot;
        private String firstName;
        private String lastName;
        private String username;
        private String languageCode;

        private Builder() {
        }

        public static Builder user() {
            return new Builder();
        }

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder isBot(boolean isBot) {
            this.isBot = isBot;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder languageCode(String languageCode) {
            this.languageCode = languageCode;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}

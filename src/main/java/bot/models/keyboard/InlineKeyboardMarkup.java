package bot.models.keyboard;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Optional;

public class InlineKeyboardMarkup {
    String text;
    Optional<String> url;
    Optional<String> callbackData;
    Optional<String> webApp;

    public InlineKeyboardMarkup(String text,
                                Optional<String> url,
                                @JsonProperty("callback_data") Optional<String> callbackData,
                                @JsonProperty("web_app") Optional<String> webApp) {
        this.text = text;
        this.url = url;
        this.callbackData = callbackData;
        this.webApp = webApp;
    }

    private InlineKeyboardMarkup(Builder builder) {
        this.text = builder.text;
        this.url = builder.url;
        this.callbackData = builder.callbackData;
        this.webApp = builder.webApp;
    }

    public static final class Builder {
        private String text;
        private Optional<String> url;
        private Optional<String> callbackData;
        private Optional<String> webApp;

        private Builder() {
        }

        public static Builder inlineKeyboardMarkup() {
            return new Builder();
        }

        public Builder text(String text) {
            this.text = text;
            return this;
        }

        public Builder url(Optional<String> url) {
            this.url = url;
            return this;
        }

        public Builder callbackData(Optional<String> callbackData) {
            this.callbackData = callbackData;
            return this;
        }

        public Builder webApp(Optional<String> webApp) {
            this.webApp = webApp;
            return this;
        }

        public InlineKeyboardMarkup build() {
            return new InlineKeyboardMarkup(this);
        }
    }
}

package bot.models.keyboard;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Optional;

public class KeyboardButton {
    public final String text;
    public final Optional<Boolean> requestContact;
    public final Optional<Boolean> requestLocation;

    //    public final request_poll;

    public KeyboardButton(String text, @JsonProperty("request_contact") Optional<Boolean> requestContact,
                          @JsonProperty("request_location") Optional<Boolean> requestLocation) {
        this.text = text;
        this.requestContact = requestContact;
        this.requestLocation = requestLocation;
    }

    private KeyboardButton(Builder builder) {
        this.text = builder.text;
        this.requestContact = builder.requestContact;
        this.requestLocation = builder.requestLocation;
    }

    public static final class Builder {
        private String text;
        private Optional<Boolean> requestContact;
        private Optional<Boolean> requestLocation;

        private Builder() {
        }

        public static Builder keyboardButton() {
            return new Builder();
        }

        public Builder text(String text) {
            this.text = text;
            return this;
        }

        public Builder requestContact(Optional<Boolean> requestContact) {
            this.requestContact = requestContact;
            return this;
        }

        public Builder requestLocation(Optional<Boolean> requestLocation) {
            this.requestLocation = requestLocation;
            return this;
        }

        public KeyboardButton build() {
            return new KeyboardButton(this);
        }
    }


}

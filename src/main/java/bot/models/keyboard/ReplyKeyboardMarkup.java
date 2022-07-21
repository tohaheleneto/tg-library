package bot.models.keyboard;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Optional;

/**
 * https://core.telegram.org/bots/api#replykeyboardmarkup
 */
public class ReplyKeyboardMarkup extends ReplyKeyboard {
    public final List<List<KeyboardButton>> keyboard;
    public final Optional<Boolean> resizeKeyboard;
    public final Optional<Boolean> oneTimeKeyboar;
    public final Optional<Boolean> inputFieldPlaceholder;
    public final Optional<Boolean> selective;

    public ReplyKeyboardMarkup(List<List<KeyboardButton>> keyboard,
                               @JsonProperty("resize_keyboard") Optional<Boolean> resizeKeyboard,
                               @JsonProperty("one_time_keyboar") Optional<Boolean> oneTimeKeyboar,
                               @JsonProperty("input_field_placeholder") Optional<Boolean> inputFieldPlaceholder,
                               Optional<Boolean> selective) {
        this.keyboard = keyboard;
        this.resizeKeyboard = resizeKeyboard;
        this.oneTimeKeyboar = oneTimeKeyboar;
        this.inputFieldPlaceholder = inputFieldPlaceholder;
        this.selective = selective;
    }

    private ReplyKeyboardMarkup(Builder builder) {
        this.keyboard = builder.keyboard;
        this.resizeKeyboard = builder.resizeKeyboard;
        this.oneTimeKeyboar = builder.oneTimeKeyboar;
        this.inputFieldPlaceholder = builder.inputFieldPlaceholder;
        this.selective = builder.selective;
    }


    public static final class Builder {
        private List<List<KeyboardButton>> keyboard;
        private Optional<Boolean> resizeKeyboard;
        private Optional<Boolean> oneTimeKeyboar;
        private Optional<Boolean> inputFieldPlaceholder;
        private Optional<Boolean> selective;

        private Builder() {
        }

        public static Builder replyKeyboardMarkup() {
            return new Builder();
        }

        public Builder keyboard(List<List<KeyboardButton>> keyboard) {
            this.keyboard = keyboard;
            return this;
        }

        public Builder resizeKeyboard(Optional<Boolean> resizeKeyboard) {
            this.resizeKeyboard = resizeKeyboard;
            return this;
        }

        public Builder oneTimeKeyboar(Optional<Boolean> oneTimeKeyboar) {
            this.oneTimeKeyboar = oneTimeKeyboar;
            return this;
        }

        public Builder inputFieldPlaceholder(Optional<Boolean> inputFieldPlaceholder) {
            this.inputFieldPlaceholder = inputFieldPlaceholder;
            return this;
        }

        public Builder selective(Optional<Boolean> selective) {
            this.selective = selective;
            return this;
        }

        public ReplyKeyboardMarkup build() {
            return new ReplyKeyboardMarkup(this);
        }
    }
}

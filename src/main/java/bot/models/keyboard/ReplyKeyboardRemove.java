package bot.models.keyboard;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * https://core.telegram.org/bots/api#replykeyboardremove
 */
public class ReplyKeyboardRemove extends ReplyKeyboard{
    @JsonProperty("remove_keyboard")
    boolean removeKeyboard = true;

}

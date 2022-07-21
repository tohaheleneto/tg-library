package bot.models;

import java.util.Arrays;

public enum ChatType {
    PRIVATE("private"),
    GROUP("group"),
    SUPER_GROUP("supergroup"),
    CHANNEL("channel");

    ChatType(String type) {
        this.value = type;
    }

    public final String value;

    public static ChatType of(String s) {
        return Arrays.stream(ChatType.values())
                .filter(chatType -> chatType.value.equals(s))
                .findFirst()
                .orElseThrow();
    }
}

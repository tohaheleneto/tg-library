package bot.models;

import com.fasterxml.jackson.annotation.JsonProperty;

// TODO fix https://core.telegram.org/bots/api#chat
public class Chat {
    public final String id;
    public final ChatType type;

    //TODO
//    public final String title;

    public final String username;

    public final String firstName;
    public final String lastName;

//    only in https://core.telegram.org/bots/api#getchat
//    TODO create typ
//    public final ChatPhoto photo;

    //TODO
    // only in https://core.telegram.org/bots/api#getchat
//    public final String bio;

//Boolean has_private_forwards
    //Boolean join_to_send_messages
    // Boolean join_to_send_messages
    // String description
    // String inviteLink


    public Chat(@JsonProperty("id") String id,
                @JsonProperty("type") String type,
                @JsonProperty("first_name") String firstName,
                @JsonProperty("last_name") String lastName,
                @JsonProperty("username") String username) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.type = ChatType.of(type);
    }

    @Override
    public String toString() {
        return "Chat{" +
                "id='" + id + '\'' +
                ", first_name='" + firstName + '\'' +
                ", last_name='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}

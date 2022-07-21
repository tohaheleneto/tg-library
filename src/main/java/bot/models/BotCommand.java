package bot.models;

public class BotCommand {
    private final String command;
    private final String description;

    public BotCommand(String command, String description) {
        this.command = command;
        this.description = description;
    }

    public String getCommand() {
        return command;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "BotCommand{" +
                "command='" + command + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

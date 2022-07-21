package bot.models.to;



import bot.models.BotCommand;

import java.util.List;

/**
 * https://core.telegram.org/bots/api#setmycommands
 */
public class SetCommands {
    private final List<BotCommand> commands;

    public SetCommands(List<BotCommand> commands) {
        this.commands = commands;
    }

    public List<BotCommand> getCommands() {
        return commands;
    }
}

package bot.models.responses;

import bot.models.Message;

public class SendMessageResponse extends Response {

    public final Message result;

    public SendMessageResponse(boolean ok, String description, Message result) {
        super(ok, description);
        this.result = result;
    }

    @Override
    public String toString() {
        return "SendMessageResponse{" +
                "result=" + result +
                super.toString() +
                '}';
    }
}

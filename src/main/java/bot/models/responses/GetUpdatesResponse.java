package bot.models.responses;

import bot.models.Update;

import java.util.List;

public class GetUpdatesResponse extends Response {

    public final List<Update> result;


    public GetUpdatesResponse(boolean ok, String description, List<Update> result) {
        super(ok, description);
        this.result = result;
    }

    @Override
    public String toString() {
        return "UpdatesResponse{" +
                "result=" + result +
                super.toString() +
                '}';
    }
}

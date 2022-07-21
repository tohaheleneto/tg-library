package bot.models.responses;


public class Response {
    public final boolean ok;
    public final String description;


    public Response(boolean ok, String description) {
        this.ok = ok;
        this.description = description;
    }

    @Override
    public String toString() {
        return ", ok=" + ok +
                ", description='" + description + '\'';
    }
}

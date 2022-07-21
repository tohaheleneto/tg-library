package bot;

import bot.models.Message;
import bot.models.UpdatesRequest;
import bot.models.responses.GetUpdatesResponse;
import bot.models.responses.SendMessageResponse;
import bot.models.to.SendMessage;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

import static bot.JsonHelper.fromObject;
import static bot.JsonHelper.parse;

public class TgClient {
    static String TG_API = "https://api.telegram.org/bot";

    public TgClient(String token) {
        TG_API += token;
    }

    static HttpClient httpClient = HttpClientBuilder
            .create()
            .build();

    public GetUpdatesResponse getUpdates(UpdatesRequest updatesRequest) throws IOException {
        HttpResponse response = httpPost("/getUpdates", updatesRequest);
        return parse(body(response), GetUpdatesResponse.class);
    }
    public SendMessageResponse sendMessage(SendMessage sendMessage) throws IOException {
        HttpResponse response = httpPost("/sendMessage", sendMessage);
        return parse(body(response), SendMessageResponse.class);
    }

    public HttpResponse httpPost(String path, Object object) throws IOException {
        final var request = new HttpPost((TG_API + path));

        if (object != null) {
            final var entity = JsonHelper.jsonEntity(fromObject(object));
            request.setEntity(entity);
        }

        return httpClient.execute(request);
    }

    private String body(HttpResponse httpResponse) throws IOException {
        var entity = httpResponse.getEntity();
        if (entity == null) {
            return " ";
        }
        return EntityUtils.toString(entity);
    }
}

package bot;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.EntityBuilder;
import org.apache.http.entity.ContentType;

public class JsonHelper {
    private static final ObjectMapper objectMapper = new ObjectMapper()
            .setSerializationInclusion(JsonInclude.Include.NON_ABSENT)
            .registerModule(new Jdk8Module())
            .registerModule(new ParameterNamesModule())
            .registerModule(new JavaTimeModule());

    public static String toJsonString(JsonNode jsonNode) {
        try {
            return objectMapper.writeValueAsString(jsonNode);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static JsonNode fromObject(Object object) {
        return objectMapper.valueToTree(object);
    }

    public static byte [] toJsonBytes(JsonNode node) {
        try {
            return objectMapper.writeValueAsBytes(node);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static HttpEntity jsonEntity(JsonNode body) {
        return rawEntity(toJsonBytes(body), ContentType.APPLICATION_JSON);
    }

    public static HttpEntity rawEntity(byte[] body, ContentType contentType) {
        return EntityBuilder.create()
                .setContentType(contentType)
                .setBinary(body)
                .build();
    }

    // parse
    public static <TYPE> TYPE parse (String jsonText, Class<TYPE> type) {
        try {
           return objectMapper.readValue(jsonText, type);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}

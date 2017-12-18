package json;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class JsonObject extends Json {
    private List<JsonPair> jSons = new ArrayList<>();

    public JsonObject(JsonPair... jsonPairs) {
        jSons.addAll(Arrays.asList(jsonPairs));
    }

    @Override
    public String toJson() {
        String out = "{";
        for (JsonPair json: jSons
             ) {
            out += json.toString();
            out += ", ";
        }
        int len = out.length();
        if (len > 2){
            out = out.substring(0, out.length() - 2);
        }
        out += "}";
        return out;

    }

    public void add(JsonPair jsonPair) {
        jSons.add(jsonPair);
    }

    public Json find(String name) {
        for (JsonPair json: jSons
             ) {
            if (json.key.equals(name)){
                return json.value;
            }
        }
        return null;
    }

    public JsonObject projection(String... names) {
        JsonObject finalJson = new JsonObject();
        for (String name: names
             ) {
            for (JsonPair json1: jSons
                 ) {
                if (Objects.equals(name, json1.key)){
                    finalJson.add(json1);
                }
            }
        }
        return finalJson;
    }
}

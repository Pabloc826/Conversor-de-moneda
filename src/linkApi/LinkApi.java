package linkApi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class LinkApi {
    private String apiKey = "https://v6.exchangerate-api.com/v6/acbb957209feeb26d704408e/latest/";
    private final Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    public String getApiKey() {
        return this.apiKey;
    }

    public Gson getGson() {
        return this.gson;
    }
}

package http;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import principal.Principal;
import static java.net.http.HttpResponse.BodyHandlers.ofString;

public class ClienteHttp {
    private HttpClient client;

    public ClienteHttp(){
        this.client = HttpClient.newHttpClient();
    }

    public String obtenerDatos(String direccion){
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();

            try {
                HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
                return response.body();
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
    }
}


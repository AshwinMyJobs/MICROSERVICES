package com.clients;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.Callable;

public class RestApiCallable implements Callable<String>{

    private final String apiUrl;
    private final String requestBody;

    public RestApiCallable(String apiUrl, String requestBody) {
        this.apiUrl = apiUrl;
        this.requestBody = requestBody;
    }

    @Override
    public String call() throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .header("Content-Type", "application/json") // Example header
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
}

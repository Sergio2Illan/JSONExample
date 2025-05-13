package com.sergioillan.utilidades;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sergioillan.entidades.User;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class GetData {

    private GetData() {
        // Constructor privado para evitar instanciación
    }

    public static List<User> getDataFromAPI() throws IOException, InterruptedException {
        List<User> users;

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(APIEndpoints.USERS))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        Gson gson = new Gson();
        users = gson.fromJson(response.body(), new TypeToken<List<User>>() {}.getType());


        return users;
    }
}

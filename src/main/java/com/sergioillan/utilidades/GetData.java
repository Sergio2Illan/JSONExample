package com.sergioillan.utilidades;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sergioillan.entidades.character.Characters;
import com.sergioillan.entidades.user.User;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class GetData {

    private GetData() {
        // Constructor privado para evitar instanciación
    }

    public static List<User> getUsersFromAPI(String api) throws IOException, InterruptedException {
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

    public static Characters getCharactersFromAPI(String api) throws IOException, InterruptedException {
        Characters characters;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(api))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("JSON recibido:\n" + response.body());
        Gson gson = new Gson();
        //pongo el characters.class porque es un array de objetos, si fuera un objeto solo pondria HttpResponse.BodyHandlers.ofString() para que me lo devuelva como un string.
        characters = gson.fromJson(response.body(), Characters.class);
        return characters;
    }
}

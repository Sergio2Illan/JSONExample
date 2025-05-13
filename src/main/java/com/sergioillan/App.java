package com.sergioillan;

import com.sergioillan.entidades.character.Characters;
import com.sergioillan.entidades.user.User;
import com.sergioillan.utilidades.APIEndpoints;
import com.sergioillan.utilidades.GetData;

import java.io.IOException;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("=== Lista de usuarios ===");
        try {

            //getUsers();
            Characters characters = GetData.getCharactersFromAPI(APIEndpoints.DBZ_CHARACTERS);
            if (characters != null && characters.getPersonajes() != null) {
                characters.getPersonajes().forEach(c -> {
                    System.out.println("ID: " + c.getId());
                    System.out.println("Nombre: " + c.getName());
                    System.out.println("KI: " + c.getKi());
                    System.out.println("Afiliacion: " + c.getAffiliation());
                    System.out.println("Género: " + c.getGender());
                    System.out.println("--------------");
                });
            } else {
                System.out.println("No se pudieron obtener los personajes.");
            }

        } catch (NullPointerException e) {
            System.out.println("Error: " + e.getMessage());
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("Error de entrada/salida: " + e.getMessage());
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            System.out.println("Error de interrupción: " + e.getMessage());
            throw new RuntimeException(e);
        }


    }

    private static void getUsers() throws IOException, InterruptedException {
        List<User> users = GetData.getUsersFromAPI(APIEndpoints.USERS);
        users.stream().forEach( user -> {
            System.out.println("ID: " + user.getId());
            System.out.println("Name: " + user.getName());
            System.out.println("Username: " + user.getUsername());
            System.out.println("Email: " + user.getEmail());
            System.out.println("Phone: " + user.getPhone());
            System.out.println("Website: " + user.getWebsite());
            System.out.println("Company: " + user.getCompany().getName());
            System.out.println();
        });
    }
}

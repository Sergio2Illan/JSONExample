package com.sergioillan;

import com.sergioillan.entidades.User;
import com.sergioillan.utilidades.GetData;

import java.io.IOException;
import java.util.ArrayList;
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
            List<User> users = GetData.getDataFromAPI();
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
        } catch (IOException e) {
            System.out.println("Error de entrada/salida: " + e.getMessage());
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            System.out.println("Error de interrupción: " + e.getMessage());
            throw new RuntimeException(e);
        }


    }
}

package com.sergioillan.entidades.character;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.ArrayList;

@Data

public class Characters {
    @SerializedName("items")
    public ArrayList<Character> personajes;
    /*public Meta meta;
    public Links links;*/
}

package com.sergioillan.entidades.character;

import lombok.Data;

@Data
public class Character {
    public int id;
    public String name;
    public String ki;
    public String maxKi;
    public String race;
    public String gender;
    public String description;
    public String image;
    public String affiliation;
    public Object deletedAt;
}

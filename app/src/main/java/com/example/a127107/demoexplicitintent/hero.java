package com.example.a127107.demoexplicitintent;

import java.io.Serializable;

/**
 * Created by 127107 on 2/5/2017.
 */

public class hero implements Serializable {
    private String name;
    private int strength;
    private int technicalProwess;

    public String getName(){
        return name;
    }
    public int getStrength(){
        return strength;
    }
    public int getTechnicalProwess(){
        return technicalProwess;
    }
    public hero(String name,int strength, int technicalProwess){
        this.name = name;
        this.strength = strength;
        this.technicalProwess = technicalProwess;
    }

}

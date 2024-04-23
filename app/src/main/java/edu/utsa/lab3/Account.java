package edu.utsa.lab3;

import android.content.res.AssetManager;


import java.io.Serializable;
public class Account implements Serializable {

    private int id;

    private String name;

    private String email;

    public Account(int id, String name, String email){
        this.id = id;
        this.name = name;
        this.email = email;
    }


    public int getId(){
        return id;
    }

    private void setId(int id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }


}

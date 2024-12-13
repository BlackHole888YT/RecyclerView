package com.example.recyclerview;

import java.io.Serializable;

public class Continents implements Serializable {
    private String name;

    public Continents(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

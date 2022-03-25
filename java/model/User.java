package com.example.demoapp.model;

public class User {
    String name;
    String country;
    String id;

    public User(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public User(String name, String country, String id) {
        this.name = name;
        this.country = country;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getId() {
        return id;
    }
}

package com.example.fitnessapp.model;

public class User {

    private String username;
    private String age;
    private String email;

    public User(){

    }

    public User(String username, String age, String email) {
        this.username = username;
        this.age = age;
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }
}

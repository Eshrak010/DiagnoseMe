package com.example.diagnoseme;

public class User {
    private int id;
    private String surname;
    private String password;
    private String email;
    private int picture;

    public User(int id, String surname, String password, String email, int picture) {
        this.id = id;
        this.surname = surname;
        this.password = password;
        this.email = email;
        this.picture = picture;
    }

    public User(int id, String surname, String password, String email) {
        this.id = id;
        this.surname = surname;
        this.password = password;
        this.email = email;
    }

    public User(String surname, String email, String password) {
        this.surname = surname;
        this.password = password;
        this.email = email;
    }

    public User(String surname, String password) {
        this.surname = surname;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + surname + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", picture=" + picture +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return surname;
    }

    public void setUsername(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }
}

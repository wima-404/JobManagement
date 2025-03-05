package com.example.jobmanage.model;

public class User {
    int id;
    String email;
    String passWord;
    String Role;

    public User(int id, String email, String passWord, String role) {
        this.id = id;
        this.email = email;
        this.passWord = passWord;
        Role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }
}

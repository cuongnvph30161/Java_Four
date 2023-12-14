package com.example.assignment1.entity;

public class User {
    String id;
    String password;
    String fullname;
    Boolean admin;
    //getters & setters (Alt + Ins)

    public User() {
    }

    public User(String id, String password, String fullname, Boolean admin) {
        this.id = id;
        this.password = password;
        this.fullname = fullname;
        this.admin = admin;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }
}

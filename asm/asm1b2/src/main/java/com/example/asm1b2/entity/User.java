package com.example.asm1b2.entity;

public class User {
    String id;
    String password;
    String email;
    String fullname;
    String country;
    String gender;
    Boolean admin;

    public User() {
    }

    public User(String id, String password, String email, String fullname, String country, String gender, Boolean admin) {
        this.id = id;
        this.password = password;
        this.email = email;
        this.fullname = fullname;
        this.country = country;
        this.gender = gender;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }
}

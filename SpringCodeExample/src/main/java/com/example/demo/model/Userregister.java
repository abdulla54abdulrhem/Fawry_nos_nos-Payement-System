package com.example.demo.model;

public class Userregister {
    private  String Username;
    private  String Email;
    private  String Password;

    public void setUsername(String username) {
        this.Username = username;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public void setPassword(String password) {
        this.Password = password;
    }

    public String getUsername() {
        return this.Username;
    }

    public String getEmail() {
        return this.Email;
    }

    public String getPassword() {
        return this.Password;
    }
}

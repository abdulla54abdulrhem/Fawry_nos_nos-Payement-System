package com.example.demo.model.UserandAdmin;
public abstract class UserAbstract {
    String email;
    String password;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    String username;

    UsersAuthSystem system=new UsersAuthSystem();
    public UserAbstract(){}
    abstract boolean login(String logingEmail, String logingPassword);

}

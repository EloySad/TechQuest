package com.tq.tq.persistence.mysql.dtos;

public class UserLoginDTO {
    private String email; // Cambiado de username a email
    private String password;

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}